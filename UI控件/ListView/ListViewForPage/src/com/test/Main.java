package com.test;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	private ListView listView;
	private TextView total, current;
	private Button preTextView;
	private Button nextTextView;
	// 定义点击事件
	private OnClickListener cl;
	// 定义适配器
	private ListAdapter listadpter;
	// 定义每一页显示行数
	private int VIEW_COUNT = 10;
	// 定义的页数
	private int index = 0;
	// 泛型集合ArrayList
	private ArrayList<Students> arrayList = new ArrayList<Students>();
	// 数据操作的dao类
	StudentsDAO dao = new StudentsDAO(Main.this);
	// 实体bean
	Students students = new Students();
	// 标记：上次的ID
	int last = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 初始化界面
		initView();
		// 调用dao里面的insert()方法
		dao.insert();
		// 调用dao里面的selectAll()方法
		arrayList = dao.selectAll();
		// 实例化适配器
		listadpter = new ListAdapter(Main.this);
		// 填充适配器
		listView.setAdapter(listadpter);
		// 监听机制
		cl = new TextView.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				// 如果是上一页textview的时候，调用上一页的方法
				case R.id.txPreview:
					preView();
					break;
				case R.id.txNext:
					nextView();
					break;
				default:
					break;
				}
			}
		};
		// Item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				// 重置上次颜色为Color.WHITE
				setLastColorBlack();
				LinearLayout lLayout = (LinearLayout) view;
				TextView lText = (TextView) lLayout.getChildAt(1);
				lText.setTextColor(Color.RED);

				// 保存最新的上次ID
				last = position;
				final int pos = position;
				Toast.makeText(
						Main.this,
						"This is "
								+ index
								+ " page,is the "
								+ String.valueOf(pos + 1)
								+ " row,current date is "
								+ arrayList.get(pos + index * VIEW_COUNT)
										.getName(), Toast.LENGTH_SHORT).show();
			}
		});

		// Item长按事件
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// 重置上次颜色为Color.WHITE
				setLastColorBlack();
				LinearLayout lLayout = (LinearLayout) view;
				TextView lText = (TextView) lLayout.getChildAt(1);
				lText.setTextColor(Color.GREEN);

				// 保存最新的上次ID
				last = position;
				final int pos = position;
				Toast.makeText(
						Main.this,
						"This is "
								+ index
								+ " page,is the "
								+ String.valueOf(pos + 1)
								+ " row,current date is "
								+ arrayList.get(pos + index * VIEW_COUNT)
										.getName(), Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		preTextView.setOnClickListener(cl);
		nextTextView.setOnClickListener(cl);
		// 总页数
		total.setText("total:" + String.valueOf(arrayList.size()));
		// 当前页数
		current.setText("current:" + String.valueOf(index));
		checkView();
	}

	// 初始化界面方法
	private void initView() {
		// TODO Auto-generated method stub
		listView = (ListView) findViewById(R.id.list);
		preTextView = (Button) findViewById(R.id.txPreview);
		nextTextView = (Button) findViewById(R.id.txNext);
		total = (TextView) findViewById(R.id.total);
		current = (TextView) findViewById(R.id.current);
	}

	public void setLastColorBlack() {
		// 选中之后的颜色变成白色
		LinearLayout lastLayout = (LinearLayout) listView.getChildAt(last);
		TextView lastText = (TextView) lastLayout.getChildAt(1);
		lastText.setTextColor(Color.WHITE);

	}

	// 上一页的方法
	private void preView() {
		// TODO Auto-generated method stub
		index--;
		current.setText("current:" + String.valueOf(index));
		// 重新更新数据
		listadpter.notifyDataSetChanged();
		checkView();
	}

	// 下一页的方法
	private void nextView() {
		// TODO Auto-generated method stub
		index++;
		current.setText("current:" + String.valueOf(index));
		// 重新更新数据
		listadpter.notifyDataSetChanged();
		checkView();
	}

	// 检测是否到了第一页和最后一页
	public void checkView() {
		if (index <= 0) {
			// 如果页数小于0就让preTextView不可见
			preTextView.setEnabled(false);
			if (arrayList.size() <= VIEW_COUNT) {
				// 如果总长度小于VIEW_COUNT就让nextTextView不可见
				nextTextView.setEnabled(false);
			}
		} else if (arrayList.size() - index * VIEW_COUNT <= VIEW_COUNT) {
			// 当当前数据前进到最后一页的时候就让nextTextView不可见
			nextTextView.setEnabled(false);
		} else {
			preTextView.setEnabled(true);
			nextTextView.setEnabled(true);
		}
	}

	// 自定义适配器
	class ListAdapter extends BaseAdapter {
		Activity activity;

		public ListAdapter(Activity activity) {
			this.activity = activity;
		}

		public void notifyDataSetChanged() {
			// TODO Auto-generated method stub
			// 每次清空数据，重新填充
			arrayList.clear();
			arrayList = dao.selectAll();
			super.notifyDataSetChanged();
		}

		public int getCount() {
			// TODO Auto-generated method stub
			if (arrayList.size() - VIEW_COUNT * index < VIEW_COUNT) {
				return arrayList.size() - VIEW_COUNT * index;
			} else {
				return VIEW_COUNT;
			}
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder;
			if (arrayList != null) {
				// 根据位置来获取数据
				students = arrayList.get(position + index * VIEW_COUNT);
			}
			if (convertView == null) {
				convertView = getLayoutInflater().inflate(R.layout.list_item,
						null);
				holder = new ViewHolder();
				holder.img = (TextView) convertView.findViewById(R.id.img);
				holder.text = (TextView) convertView.findViewById(R.id.tv);
				holder.ck = (CheckBox) convertView.findViewById(R.id.ck);
				// 设置标志符
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.img.setText("ID: " + students.getId());
			holder.text.setText("Name: " + students.getName() + "——" + "Age:"
					+ students.getAge());
			final int pos = position;
			// 设置TextView点击事件
			holder.text.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(
							Main.this,
							"This is "
									+ index
									+ " page,is the "
									+ String.valueOf(pos + 1)
									+ " row,current date is "
									+ arrayList.get(pos + index * VIEW_COUNT)
											.getName(), Toast.LENGTH_SHORT)
							.show();
				}
			});
			// 设置CheckBox点击事件
			holder.ck.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					// TODO Auto-generated method stub
					if (isChecked) {
						Toast.makeText(
								Main.this,
								"This is "
										+ index
										+ " page,is the "
										+ String.valueOf(pos + 1)
										+ " row,current date is "
										+ arrayList.get(
												pos + index * VIEW_COUNT)
												.getName(), Toast.LENGTH_SHORT)
								.show();
					}
				}
			});
			return convertView;

		}
	}

	final class ViewHolder {
		TextView text;
		TextView img;
		CheckBox ck;
	}
}