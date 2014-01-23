package com.lilin.lc;

import java.util.List;
import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ListCheckBoxAdp extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Map<String, Object>> mData;

	public ListCheckBoxAdp(Main context, List<Map<String, Object>> mData1) {
		mData = mData1;
		mInflater = LayoutInflater.from(context);

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
		ViewHolder holder = null;
		// convertView为null的时候初始化convertView。
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list, null);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.cBox = (CheckBox) convertView.findViewById(R.id.cb);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(mData.get(position).get("title").toString());
		holder.cBox.setChecked(Main.isSelect[position]);
		return convertView;
	}

	public final class ViewHolder {
		public TextView title;
		public CheckBox cBox;
	}
}
