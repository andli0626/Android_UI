package com.example.viewpagerindicator_tabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @author lilin
 * @date 2013-8-14 上午8:57:38
 * @annotation Fragment
 */
public final class TestTabView extends Fragment {
	private static final String KEY_CONTENT = "TestFragment:Content";

	public static TestTabView newInstance(String content) {
		TestTabView fragment = new TestTabView();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			builder.append(content).append(" ");
		}
		builder.deleteCharAt(builder.length() - 1);
		fragment.mContent = builder.toString();

		return fragment;
	}

	private String mContent = "???";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if ((savedInstanceState != null)
				&& savedInstanceState.containsKey(KEY_CONTENT)) {
			mContent = savedInstanceState.getString(KEY_CONTENT);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TextView text = new TextView(getActivity());
		// text.setGravity(Gravity.CENTER);
		// text.setText(mContent);
		// text.setTextSize(20 * getResources().getDisplayMetrics().density);
		// text.setPadding(20, 20, 20, 20);
		//
		// LinearLayout layout = new LinearLayout(getActivity());
		// layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
		// LayoutParams.FILL_PARENT));
		// layout.setGravity(Gravity.CENTER);
		// layout.addView(text);
		//
		// return layout;
		return inflater.inflate(R.layout.tabview1, container, false);//直接通过布局文件布局

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(KEY_CONTENT, mContent);
	}
}
