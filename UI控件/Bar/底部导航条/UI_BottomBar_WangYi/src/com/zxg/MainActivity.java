package com.zxg;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {

	public TabHost tabHost = null;
	public ImageView tab_front_bg = null;
	public int oldTabViewIndex = 0;
	public int curTabViewIndex = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup();
		// 新闻
		tabHost.addTab(tabHost.newTabSpec("tab_news")
				.setIndicator(getTitleView(1)).setContent(R.id.ll_tab_news));
		// 话题
		tabHost.addTab(tabHost.newTabSpec("tab_topic")
				.setIndicator(getTitleView(2)).setContent(R.id.ll_tab_topic));
		// 图片
		tabHost.addTab(tabHost.newTabSpec("tab_photo")
				.setIndicator(getTitleView(3)).setContent(R.id.ll_tab_photo));
		// 跟帖
		tabHost.addTab(tabHost.newTabSpec("tab_comment")
				.setIndicator(getTitleView(4)).setContent(R.id.ll_tab_comment));
		// 投票
		tabHost.addTab(tabHost.newTabSpec("tab_vote")
				.setIndicator(getTitleView(5)).setContent(R.id.ll_tab_vote));
		tabHost.setCurrentTab(0);

		tab_front_bg = (ImageView) findViewById(R.id.tab_front_bg);

		MyOnTabChangeListener newsReaderOnTabChangeListener = new MyOnTabChangeListener(
				this);
		this.tabHost.setOnTabChangedListener(newsReaderOnTabChangeListener);
	}

	private View getTitleView(int paramInt) {
		LinearLayout localLinearLayout = new LinearLayout(this);
		localLinearLayout.setOrientation(1);
		localLinearLayout.setGravity(17);
		TextView localTextView = new TextView(this);
		localTextView.setId(R.string.tab_tv_id);
		LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(
				-1, -1);
		switch (paramInt) {
		case 1:
			Drawable localDrawable1 = getResources().getDrawable(
					R.drawable.current_news_tab);
			localTextView.setBackgroundDrawable(localDrawable1);
			break;
		case 2:
			Drawable localDrawable2 = getResources().getDrawable(
					R.drawable.back_topic_tab);
			localTextView.setBackgroundDrawable(localDrawable2);
			break;
		case 3:
			Drawable localDrawable3 = getResources().getDrawable(
					R.drawable.back_picture_tab);
			localTextView.setBackgroundDrawable(localDrawable3);
			break;
		case 4:
			Drawable localDrawable4 = getResources().getDrawable(
					R.drawable.back_comment_tab);
			localTextView.setBackgroundDrawable(localDrawable4);
			break;
		case 5:
			Drawable localDrawable5 = getResources().getDrawable(
					R.drawable.back_vote_tab);
			localTextView.setBackgroundDrawable(localDrawable5);
			break;
		}
		localLinearLayout.addView(localTextView, localLayoutParams);
		return localLinearLayout;
	}
}