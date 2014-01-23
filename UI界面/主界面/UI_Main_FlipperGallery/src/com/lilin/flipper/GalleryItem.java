package com.lilin.flipper;

import com.droidful.flinggallery.R;
import com.lilin.util.GetDataList;
import com.lilin.util.SetGridView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

//Gallery的每一项
public class GalleryItem extends TableLayout implements OnClickListener {

	private Button btn1;
	private Button btn2;
	private LayoutParams params1 = new LayoutParams(
			LinearLayout.LayoutParams.FILL_PARENT,
			LinearLayout.LayoutParams.FILL_PARENT);

	private LayoutParams params2 = new LayoutParams(
			LinearLayout.LayoutParams.FILL_PARENT,
			LinearLayout.LayoutParams.WRAP_CONTENT);

	public String[] viewNames;

	public FlingGallery flingGallery;

	public GalleryItem(final Context context, int pos,
			final FlingGallery flingGallery) {
		super(context);

		this.viewNames = MainView.items;
		this.flingGallery = flingGallery;
		this.setOrientation(LinearLayout.VERTICAL);
		this.setLayoutParams(params1);
		if (pos == 1)
		// 城管通主界面
		{
			String[] cgt_name = getResources().getStringArray(R.array.cgt_name);
			int[] cgt_image = { R.drawable.wtsb, R.drawable.wdrw,
					R.drawable.jyzf, R.drawable.yysb, R.drawable.dtll,
					R.drawable.lmqw, R.drawable.yyhj, R.drawable.jrts,
					R.drawable.sjtb };// 单项的图片
			this.setBackgroundColor(Color.WHITE);
			GridView gv = new GridView(context);
			// 设置GridView的相应参数
			SetGridView.setGridView(gv,// 布局对象视图
					3,// 列数
					7,// 垂直间距
					7,// 水平间距
					0,// 背景色
					0,// 背景图片
					Gravity.CENTER// 位置
					);

			SimpleAdapter simpleAdapter = new SimpleAdapter(context,
					GetDataList.getDataList(cgt_name, cgt_image),
					R.layout.mainview_item, new String[] { "images", "name" },
					new int[] { R.id.item_image, R.id.item_text });
			gv.setAdapter(simpleAdapter);
			// android:descendantFocusability=”blocksDescendant”
			// gv.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
			// 点击事件
			gv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					position = position + 1;
					switch (position) {
					case 1:
						// 1
					{
						Toast.makeText(context, String.valueOf(position), 2000)
								.show();
					}

						break;
					case 2:
						// 2
					{
						Toast.makeText(context, String.valueOf(position), 2000)
								.show();
					}
						break;
					default:
						break;
					}
				}
			});
			this.addView(gv, params2);
			// LinearLayout linearLayout = new LinearLayout(context);
			// linearLayout.setLayoutParams(params2);
			// linearLayout.setGravity(LinearLayout.HORIZONTAL);
			//
			// btn1 = new Button(context);
			// btn1.setText("<<向左");
			// btn1.setId(1);
			// btn1.setGravity(1);
			//
			// btn2 = new Button(context);
			// btn2.setText("向右>>");
			// btn2.setId(2);
			// btn2.setGravity(1);
			//
			// btn1.setOnClickListener(this);
			// btn2.setOnClickListener(this);
			//
			// linearLayout.addView(btn1);
			// linearLayout.addView(btn2);
			// this.addView(linearLayout, params2);
		} else if (pos == 0)
		// OA主界面
		{
			int[] oa_image = { R.drawable.txl, R.drawable.tzgg,
					R.drawable.gwyj, R.drawable.fjgl, R.drawable.gwcl,
					R.drawable.xxfb, R.drawable.xstx,
					R.drawable.meetingmanager_ico, R.drawable.xtsz,
					R.drawable.sjtb, R.drawable.bfhy, R.drawable.rjgx };

			String[] oa_name = getResources().getStringArray(R.array.oa_name);
			this.setBackgroundColor(Color.WHITE);
			GridView gv = new GridView(context);
			// 设置GridView的相应参数
			SetGridView.setGridView(gv,// 布局对象视图
					3,// 列数
					7,// 垂直间距
					7,// 水平间距
					0,// 背景色
					0,// 背景图片
					Gravity.CENTER// 位置
					);

			SimpleAdapter simpleAdapter = new SimpleAdapter(context,
					GetDataList.getDataList(oa_name, oa_image),
					R.layout.mainview_item, new String[] { "images", "name" },
					new int[] { R.id.item_image, R.id.item_text });
			gv.setAdapter(simpleAdapter);
			// gv.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
			// 点击事件
			gv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					position = position + 1;
					switch (position) {
					case 1:
						// 1
					{
						Toast.makeText(context, String.valueOf(position), 2000)
								.show();
					}

						break;
					case 2:
						// 2
					{
						Toast.makeText(context, String.valueOf(position), 2000)
								.show();
					}
						break;
					default:
						break;
					}
				}
			});
			this.addView(gv, params2);
			// 添加按钮
			// LinearLayout linearLayout = new LinearLayout(context);
			// linearLayout.setLayoutParams(params2);
			// linearLayout.setGravity(LinearLayout.HORIZONTAL);
			//
			// btn1 = new Button(context);
			// btn1.setText("<<向左");
			// btn1.setId(1);
			// btn1.setGravity(1);
			//
			// btn2 = new Button(context);
			// btn2.setText("向右>>");
			// btn2.setId(2);
			// btn2.setGravity(1);
			//
			// btn1.setOnClickListener(this);
			// btn2.setOnClickListener(this);
			//
			// linearLayout.addView(btn1);
			// linearLayout.addView(btn2);
			// this.addView(linearLayout, params2);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case 1:
			flingGallery.movePrevious();
			break;
		case 2:
			flingGallery.moveNext();
			break;

		default:
			break;
		}
	}
}
