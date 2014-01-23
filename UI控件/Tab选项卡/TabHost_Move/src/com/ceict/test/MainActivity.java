package com.ceict.test;

import android.app.TabActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends TabActivity {
	TabHost tabhost;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tabhost = getTabHost();

		// 7个标签
		tabhost.addTab(tabhost.newTabSpec(0 + "").setIndicator("测试")
				.setContent(R.id.textview01));
		tabhost.addTab(tabhost.newTabSpec(1 + "").setIndicator("标题")
				.setContent(R.id.textview01));
		tabhost.addTab(tabhost.newTabSpec(2 + "").setIndicator("办公")
				.setContent(R.id.textview01));
		tabhost.addTab(tabhost.newTabSpec(3 + "").setIndicator("通讯")
				.setContent(R.id.textview01));
		tabhost.addTab(tabhost.newTabSpec(4 + "").setIndicator("邮件")
				.setContent(R.id.textview01));
		tabhost.addTab(tabhost.newTabSpec(5 + "").setIndicator("私信")
				.setContent(R.id.textview01));
		tabhost.addTab(tabhost.newTabSpec(6 + "").setIndicator("通知")
				.setContent(R.id.textview01));

		TabWidget tabWidget = tabhost.getTabWidget();
		// 标签的个数
		int count = tabWidget.getChildCount();
		// 获取手机屏幕的宽高
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;
		int screenheight = displayMetrics.heightPixels;
		// 我的手机是：320*480
		System.out.println(screenWidth + "*" + screenheight);

		if (count >= 4) {
			for (int i = 0; i < count; i++) {
				// 设置每个标签的宽度，为屏幕的1/4
				tabWidget.getChildTabViewAt(i).setMinimumWidth(
						(screenWidth) / 4);
			}
		}
	}
}