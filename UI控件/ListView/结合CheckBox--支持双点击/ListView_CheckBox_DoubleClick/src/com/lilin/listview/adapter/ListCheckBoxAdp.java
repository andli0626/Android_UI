package com.lilin.listview.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lilin.listview.ListCheckBoxView;
import com.lilin.listview.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ListCheckBoxAdp extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Map<String, Object>> mData;
	// 选中项：记录每个listitem的状态
	public static Map<Integer, Boolean> isSelected;

	public ListCheckBoxAdp(Context context, List<Map<String, Object>> mData1) {
		mInflater = LayoutInflater.from(context);
		this.mData = mData1;
		// 初始状态全部为false。
		isSelected = new HashMap<Integer, Boolean>();
		for (int i = 0; i < mData.size(); i++) {
			isSelected.put(i, false);
		}
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
			convertView = mInflater.inflate(R.layout.listview_item, null);
			holder.themename = (TextView) convertView
					.findViewById(R.id.themename);
			holder.collectdate = (TextView) convertView
					.findViewById(R.id.collectdate);
			holder.guid = (TextView) convertView.findViewById(R.id.guid);
			holder.status = (TextView) convertView.findViewById(R.id.status);
			holder.addressname = (TextView) convertView
					.findViewById(R.id.addressname);
			holder.checkbox = (CheckBox) convertView
					.findViewById(R.id.select_checkbox);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.themename.setText(mData.get(position).get("themename")
				.toString());
		holder.collectdate.setText(mData.get(position).get("collectdate")
				.toString());
		holder.guid.setText(mData.get(position).get("guid").toString());
		holder.status.setText(mData.get(position).get("status").toString());
		holder.addressname.setText(mData.get(position).get("addressname")
				.toString());
		holder.checkbox.setChecked(isSelected.get(position));

		// checkbox的点击事件
		final CheckBox myCheckBox = holder.checkbox;
		final int arg2 = position;
		myCheckBox.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 记录CheckBox的状态
				if (isSelected.get(arg2)) {
					isSelected.put(arg2, false);
				} else {
					isSelected.put(arg2, true);
				}
				// 此句注释掉：解决点选checkbox后，ListView自动向上滚动的问题
				// notifyDataSetChanged();
				String msg = "";
				for (int i = 0; i < isSelected.size(); i++) {
					if (isSelected.get(i) == true) {
						msg = msg + i + ";";
					}
				}
				ListCheckBoxView.index = msg;
			}
		});
		return convertView;
	}

	public final class ViewHolder {
		public TextView themename;
		public TextView collectdate;
		public TextView guid;
		public TextView status;
		public TextView addressname;
		public CheckBox checkbox;
	}
}