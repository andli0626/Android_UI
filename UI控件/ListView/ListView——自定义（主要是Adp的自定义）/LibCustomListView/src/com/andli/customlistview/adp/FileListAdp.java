package com.andli.customlistview.adp;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.andli.customlistview.uixml.FileListItemXML;

public class FileListAdp extends BaseAdapter {
	List<Map<String, Object>> mdata;

	Context context;

	public FileListAdp(Context context, List<Map<String, Object>> _mdata) {
		this.context = context;
		this.mdata = _mdata;
	}

	public int getCount() {
		return mdata.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		return new FileListItemXML(context, mdata.get(position));
	}

}
