package com.jj.viewpager;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainView extends ActivityGroup {
	LinearLayout layout;
	ViewPager mViewPage;
	ArrayList<View> pageList;

	LinearLayout indexPointsLayout;
	ArrayList<ImageView> imageViews;

	int curPageIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.changebtn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				mViewPage.setCurrentItem(3, false);// 取消切换动画

			}
		});

		mViewPage = (ViewPager) findViewById(R.id.vp_contains);
		indexPointsLayout = (LinearLayout) findViewById(R.id.iv_image);

		InitPages();
		InitIndexPoints();

		mViewPage.setAdapter(new ViewPageAdp(this, pageList));

		mViewPage.setCurrentItem(1);

		mViewPage.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				curPageIndex = arg0;
				Log.i("andli", "当前页面=" + curPageIndex);
				updateIndexPoints(arg0);
				if (arg0 == imageViews.size() - 1 || arg0 == 0) {
					if (arg0 == 0) {
						mViewPage.setCurrentItem(arg0 + 1);
						imageViews.get(1).setBackgroundResource(R.drawable.d2);
					} else {
						mViewPage.setCurrentItem(arg0 - 1);
						imageViews.get(arg0 - 1).setBackgroundResource(
								R.drawable.d2);
					}
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		mViewPage.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				return false;
			}
		});
	}

	// 初始化页面
	void InitPages() {
		pageList = new ArrayList<View>();

		// 空页面
		View view00 = getLocalActivityManager().startActivity("activity01",
				new Intent(this, View0.class)).getDecorView();

		// 页面一
		View view01 = getLocalActivityManager().startActivity("activity01",
				new Intent(this, View1.class)).getDecorView();

		// 页面二
		View view02 = getLocalActivityManager().startActivity("activity02",
				new Intent(this, View3.class)).getDecorView();

		// 页面三
		View view03 = getLocalActivityManager().startActivity("activity02",
				new Intent(this, View2.class)).getDecorView();

		// 空页面
		View view04 = getLocalActivityManager().startActivity("activity01",
				new Intent(this, View0.class)).getDecorView();

		pageList.add(view00);
		pageList.add(view01);
		pageList.add(view02);
		pageList.add(view03);
		pageList.add(view04);
	}

	// 初始化底部点
	void InitIndexPoints() {
		imageViews = new ArrayList<ImageView>();
		ImageView imageView;

		for (int i = 0; i < pageList.size(); i++) {
			imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(5, 5));
			imageView.setBackgroundResource(R.drawable.d1);
			LinearLayout.LayoutParams indexImgParams = new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
			indexImgParams.leftMargin = 20;
			indexImgParams.rightMargin = 20;
			indexPointsLayout.addView(imageView, indexImgParams);

			if (i == 0 || i == pageList.size() - 1) {
				imageView.setVisibility(View.GONE);
			}
			if (i == 1) {
				imageView.setBackgroundResource(R.drawable.d2);
			}
			imageViews.add(imageView);
		}
	}

	public void updateIndexPoints(int index) {
		for (int i = 1; i < imageViews.size(); i++) {

			if (index == i) {
				imageViews.get(i).setBackgroundResource(R.drawable.d2);

			} else
				imageViews.get(i).setBackgroundResource(R.drawable.d1);

		}

	}

}
