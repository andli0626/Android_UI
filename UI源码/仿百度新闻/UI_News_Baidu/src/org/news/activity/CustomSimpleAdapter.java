package org.news.activity;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class CustomSimpleAdapter extends SimpleAdapter {

	public CustomSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = super.getView(position, convertView, parent);
		//设置GridView中第一个TextView的背景
		if(position == 0){
			TextView text = (TextView) v;
			text.setTextColor(Color.WHITE);
			text.setBackgroundResource(R.drawable.image_categorybar_item_selected_background);
		}
		return v;
	}

	
}
