package com.epoint.android.customui.listview;

import java.util.Map;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author lilin
 * @date 2012-12-15 下午10:09:30
 * @annotation ListView的每一项样式---用代码来实现XML布局
 */
public class DataListItemXML extends LinearLayout {

	public TextView topTextView;
	public TextView midTextView;
	public TextView bottomTextView;

	public DataListItemXML(Context context, Map<String, Object> mData) {
		super(context);
		this.setOrientation(VERTICAL);

		topTextView = new TextView(context);
		midTextView = new TextView(context);
		bottomTextView = new TextView(context);

		topTextView.setText(mData.get("themename").toString());
		midTextView.setText(mData.get("addressname").toString());
		bottomTextView.setText(mData.get("collectdate").toString());

		LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		addView(topTextView, params);
		addView(midTextView, params);
		addView(bottomTextView, params);
	}

}
