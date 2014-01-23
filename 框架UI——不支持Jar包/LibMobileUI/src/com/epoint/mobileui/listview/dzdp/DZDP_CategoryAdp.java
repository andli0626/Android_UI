package com.epoint.mobileui.listview.dzdp;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.epoint.android.frameui.R;

public class DZDP_CategoryAdp extends BaseAdapter {

	LayoutInflater mInflater;
	List<Map<String, Object>> mData;
	Context context;

	public DZDP_CategoryAdp(Context con, List<Map<String, Object>> _mData) {
		this.context = con;
		this.mInflater = LayoutInflater.from(con);
		mData = _mData;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();

			convertView = mInflater.inflate(R.layout.listitem_dzdpcategory,
					null);
			convertView.setMinimumHeight(100);
			holder.img = (ImageView) convertView
					.findViewById(R.id.category_icon);
			holder.title = (TextView) convertView
					.findViewById(R.id.category_name);

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.img.setBackgroundResource((Integer) mData.get(position).get(
				"img"));
		holder.title.setText((String) mData.get(position).get("title"));

		return convertView;
	}

	public final class ViewHolder {
		public ImageView img;
		public TextView title;
	}
}
