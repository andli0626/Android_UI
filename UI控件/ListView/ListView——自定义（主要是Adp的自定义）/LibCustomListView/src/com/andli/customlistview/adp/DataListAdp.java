package com.andli.customlistview.adp;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.andli.customlistview.uixml.DataListItemXML;

/**
 * 
 * @author lilin
 * @date 2012-12-15 下午9:30:50
 * @annotation 简单的显示数据列表（适配器）：纯代码实现，未用到XML---为了能打包成jar文件
 */
public class DataListAdp extends BaseAdapter {
	private List<Map<String, Object>> mData;
	private Context con;

	public DataListAdp(Context context, List<Map<String, Object>> _mData) {
		con = context;
		this.mData = _mData;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout itemlayout = new DataListItemXML(con, mData.get(position));
		return itemlayout;
	}

}