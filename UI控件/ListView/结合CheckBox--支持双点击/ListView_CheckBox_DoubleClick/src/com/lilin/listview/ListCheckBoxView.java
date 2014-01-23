package com.lilin.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.lilin.listview.adapter.ListCheckBoxAdp;
import com.lilin.listview.adapter.ListCheckBoxAdp.ViewHolder;
import com.lilin.listview.modal.TestModel;
import com.lilin.listview.parentview.ParentView;
import com.lilin.listview.util.JieXiXMLHelper;
import com.lilin.listview.util.XMLHelp;

/**
 * 采集任务列表界面
 * 
 * @author lilin
 * @date 2012-2-3 上午11:34:41
 * @ClassName: ReportTaskListView
 */
public class ListCheckBoxView extends ParentView {
	private ListView mListView;
	private List<Map<String, Object>> mdate;
	private ArrayList<TestModel> mArrayList;
	private ListCheckBoxAdp listCheckBoxAdp;
	// 从适配器传过来的选中的Index
	public static String index = "";
	private ProgressDialog m_Dialog;
	private Handler handler = new Handler();

	// 获取数据的方法
	protected List<Map<String, Object>> getDate() {
		// String dbname = getString(R.string.dbname);
		// String username = DbUtil.getLoginInfo(CollectmListView.this,
		// dbname)
		// .get(0).username;
		// String seamUrl = gv.getBackurl();
		// seamUrl += "?requestType=getCollectTaskList&username=" + username;
		// HttpTask ht = new HttpTask();
		// String backString = ht.getSeamBackStr(seamUrl);

		/* 测试数据：直接读取XML文件 */
		String backString = XMLHelp.XMLFileToString("TestData.xml", this);
		if (backString.indexOf("connection timed out") > -1) {
			showToast("网络连接超时！");
		} else {
			// 解析数据
			mArrayList = JieXiXMLHelper.CollectTaskListXML(backString);
			if (mArrayList.size() > 0) {// 不为空
				// 将数据绑定到键值对上
				List<Map<String, Object>> mData;
				mData = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < mArrayList.size(); i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("themename", mArrayList.get(i).getCategoryname());
					map.put("collectdate", mArrayList.get(i).getCollectdate());
					map.put("guid", mArrayList.get(i).getRowguid().toString());
					map.put("addressname", "("
							+ mArrayList.get(i).getAddressname() + ")");
					String status = mArrayList.get(i).getStatus().toString();
					if (status.equals("0")) {
						map.put("status", "编辑中");
					} else if (status.equals("2")) {
						map.put("status", "已上报");
					} else if (status.equals("3")) {
						map.put("status", "已汇总");
					} else if (status.equals("1")) {
						map.put("status", "已下发");
					} else {
						map.put("status", "");
					}

					mData.add(map);
				}
				return mData;
			}
		}
		return null;
	}

	public void showToast(final String message) {
		handler.post(new Runnable() {
			public void run() {
				Toast.makeText(getApplicationContext(), message, 3000).show();
			}
		});
	}

	@Override
	public int getLayoutInt() {
		return R.layout.main;
	}

	/* 生成Menu菜单 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, "删除选中");
		return true;
	}

	/* Menu菜单事件 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0: {
			String indexs[] = index.split(";");
			if (indexs.length > 0 && !indexs[0].equals(""))
			// 判断有无数据可删除
			{
				Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("确定要删除选中吗？");
				// builder.setIcon(R.drawable.epoint2);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								showToast(index);
								showToast("删除选定成功!");
								// 刷新
								// freshImgListView();
							}
						});
				builder.setNegativeButton("取消", null);
				builder.create().show();
			} else if (mdate.size() == 0) {
				Toast.makeText(getApplicationContext(), "列表为空!", 5000).show();
			} else if (indexs[0].equals("")) {
				Toast.makeText(getApplicationContext(), "请选择要删除的数据!", 5000)
						.show();
			}
		}
			break;
		}
		return true;
	}

	// 初始化ListView
	public void freshListView() {
		new Thread() {
			public void run() {
				doInHandler();
			};
		}.start();
	}

	public void doInHandler() {
		handler.post(new Runnable() {
			public void run() {
				mdate = getDate();// 向服务器请求数据
				if (mdate != null) {
					listCheckBoxAdp = new ListCheckBoxAdp(
							ListCheckBoxView.this, mdate);// 声明适配器
					mListView.setAdapter(listCheckBoxAdp);
				}
				m_Dialog.dismiss();
			}
		});
	}

	@Override
	public void initControls() {
		title_txt.setText("ListCheckBox");
		mListView = (ListView) findViewById(R.id.tasklist);
		m_Dialog = ProgressDialog.show(this, null, "正在更新列表...", true);
		freshListView();
		mListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ViewHolder holder = (ViewHolder) arg1.getTag();
				String themename = holder.themename.getText().toString();
				showToast(themename);
			}
		});

	}
}
