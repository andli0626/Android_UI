package com.lilin.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import com.andli.customlistview.adp.DataListAdp;
import com.andli.customlistview.model.TestData;
import com.andli.customlistview.util.XMLHelp;

public class TestView extends Activity {
	private ListView mListView;
	private List<Map<String, Object>> mdate;
	private ArrayList<TestData> dataList;
	private DataListAdp listCheckBoxAdp;
	private ProgressDialog m_Dialog;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		mListView = (ListView) findViewById(R.id.tasklist);
		m_Dialog = ProgressDialog.show(this, null, "正在更新列表...", true);
		freshListView();

	}

	// 获取数据的方法
	protected List<Map<String, Object>> getDate() {
		String backString = XMLHelp.XMLFileToString("customlist_testdata.xml",
				this);
		// 解析数据
		dataList = XMLHelp.CollectTaskListXML(backString);
		if (dataList.size() > 0) {// 不为空
			List<Map<String, Object>> mData;
			mData = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < dataList.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("themename", dataList.get(i).getCategoryname());
				map.put("collectdate", dataList.get(i).getCollectdate());
				map.put("guid", dataList.get(i).getRowguid().toString());
				map.put("addressname", "(" + dataList.get(i).getAddressname()
						+ ")");
				mData.add(map);
			}
			return mData;
		}
		return null;
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
					listCheckBoxAdp = new DataListAdp(TestView.this,
							mdate);// 声明适配器
					mListView.setAdapter(listCheckBoxAdp);
				}
				m_Dialog.dismiss();
			}
		});
	}

}
