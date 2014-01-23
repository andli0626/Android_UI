package com.and.netease;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.epoint.mobileui.focusimg.FocusImgView;
import com.epoint.mobileui.listview.dzdp.DZDP_CategoryAdp;
import com.epoint.mobileui.listview.dzdp.DZDP_CategoryTestData;

public class SHHP_Tab_HPYWView extends Activity implements OnClickListener {
	RelativeLayout layout;

	TextView tv_front;

	TextView title1;
	TextView title2;
	TextView title3;
	TextView title4;
	TextView title5;
	TextView title6;

	TextView[] titleTextViews;


	RelativeLayout contentLayout;
	
	int imgs[] = { R.drawable.test1, R.drawable.test2, R.drawable.test3,
			R.drawable.test4, R.drawable.test5 };

	String titles[] = { "“2012金秋颂华章”在天坛世纪广场举行", "2012年世界游泳锦标赛奋力的拼搏",
			"太空探索进入新的纪元：采用太空热气球", "杭州地铁无故停运30分钟 官方未解释", "巴西举办趣味色彩赛跑 选手个个变彩人" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hpywview);

		initViews();
	}

	private void initViews() {
		layout = (RelativeLayout) findViewById(R.id.layout_title_bar);

		title1 = (TextView) findViewById(R.id.title1);
		title2 = (TextView) findViewById(R.id.title2);
		title3 = (TextView) findViewById(R.id.title3);
		title4 = (TextView) findViewById(R.id.title4);
		title5 = (TextView) findViewById(R.id.title5);
		title6 = (TextView) findViewById(R.id.title6);

		title1.setOnClickListener(this);
		title2.setOnClickListener(this);
		title3.setOnClickListener(this);
		title4.setOnClickListener(this);
		title5.setOnClickListener(this);
		title6.setOnClickListener(this);

		titleTextViews = new TextView[] { title1, title2, title3, title4,
				title5, title6 };

		// 添加焦点图
		contentLayout = (RelativeLayout) findViewById(R.id.layout_content);
		Bitmap bmps[] = new Bitmap[imgs.length];
		for (int i = 0; i < bmps.length; i++) {
			bmps[i] = BitmapFactory.decodeResource(getResources(), imgs[i]);
		}

		FocusImgView focusImgView = new FocusImgView(this, titles, bmps);

		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		contentLayout.addView(focusImgView, params);

		// 添加新闻列表
		ListView mListView = (ListView) findViewById(R.id.categorylist);

		DZDP_CategoryAdp adp = new DZDP_CategoryAdp(this,
				DZDP_CategoryTestData.getData());
		mListView.setAdapter(adp);
		title1.setTextColor(Color.RED);

	}

	@Override
	public void onClick(View v) {
		UpdateTitleColor(v);
		if (v == title1) {
		} else if (v == title2) {

		} else if (v == title3) {

		} else if (v == title4) {

		} else if (v == title5) {

		}

	}

	public void UpdateTitleColor(View v) {
		for (int i = 0; i < titleTextViews.length; i++) {
			if (titleTextViews[i] == v) {
				titleTextViews[i].setTextColor(Color.RED);
			} else {
				titleTextViews[i].setTextColor(Color.BLACK);
			}
		}
	}

}
