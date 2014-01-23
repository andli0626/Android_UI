package com.andli.customlistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.widget.ListView;

import com.andli.customlistview.adp.DataListAdp;
import com.andli.customlistview.model.TestData;
import com.andli.customlistview.util.XMLHelp;

/**
 * 
 * @author lilin
 * @date 2012-12-15 下午9:07:03
 * @annotation 自定义ListView
 */
public class ADFListViewShowData1 extends ListView {

	public ADFListViewShowData1(Context context) {
		super(context);
	}

	public ADFListViewShowData1(Context context,
			List<Map<String, Object>> mTestData) {
		super(context);
	}

	// 测试模式
	public ADFListViewShowData1(Context context, boolean isTest) {

		super(context);
		if (isTest) {
			mTestData = getTestDate(context);// 向服务器请求数据
			if (mTestData != null) {
				listCheckBoxAdp = new DataListAdp(context, mTestData);// 声明适配器
				this.setAdapter(listCheckBoxAdp);
			}
		}
	}

	private List<Map<String, Object>> mTestData;
	private ArrayList<TestData> dataList;
	private DataListAdp listCheckBoxAdp;

	// 获取数据的方法
	protected List<Map<String, Object>> getTestDate(Context con) {
		String backString = XMLHelp.XMLFileToString("customlist_testdata.xml",
				con);
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

}
