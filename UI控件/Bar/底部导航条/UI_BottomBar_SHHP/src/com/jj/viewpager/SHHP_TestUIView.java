package com.jj.viewpager;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SHHP_TestUIView extends ActivityGroup implements OnClickListener {
	LinearLayout layout;
	ViewPager mViewPage;
	ArrayList<View> pageList;
	LayoutInflater mInflater;

	ImageView nextImg;
	ImageView beforeImg;

	View view1;
	View view2;

	public static Button tab1;
	public static Button tab2;
	public static Button tab3;
	public static Button tab4;
	public static Button tab5;
	public static Button tab6;
	public static Button tab7;
	public static Button tab8;

	// 初始化页面
	void InitPages() {
		pageList = new ArrayList<View>();

		// 页面一
		view1 = mInflater.inflate(R.layout.shhp_main_footview1, null);
		nextImg = (ImageView) view1.findViewById(R.id.nextimg);

		// 页面二
		view2 = mInflater.inflate(R.layout.shhp_main_footview2, null);

		beforeImg = (ImageView) view2.findViewById(R.id.beforeimg);
		pageList.add(view1);
		pageList.add(view2);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shhp_test);

		mInflater = LayoutInflater.from(this);

		mViewPage = (ViewPager) findViewById(R.id.vp_contains);

		InitPages();

		mViewPage.setAdapter(new ViewPageAdp(this, pageList));

		mViewPage.setCurrentItem(0);
		beforeImg.setVisibility(View.INVISIBLE);
		nextImg.setVisibility(View.VISIBLE);

		mViewPage.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				if (arg0 == 0) {
					beforeImg.setVisibility(View.INVISIBLE);
					nextImg.setVisibility(View.VISIBLE);
				} else if (arg0 == 1) {
					beforeImg.setVisibility(View.VISIBLE);
					nextImg.setVisibility(View.INVISIBLE);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		tab1 = (Button) view1.findViewById(R.id.tab1);
		tab2 = (Button) view1.findViewById(R.id.tab2);
		tab3 = (Button) view1.findViewById(R.id.tab3);
		tab4 = (Button) view1.findViewById(R.id.tab4);
		tab5 = (Button) view2.findViewById(R.id.tab5);
		tab6 = (Button) view2.findViewById(R.id.tab6);
		tab7 = (Button) view2.findViewById(R.id.tab7);
		tab8 = (Button) view2.findViewById(R.id.tab8);

		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		tab4.setOnClickListener(this);
		tab5.setOnClickListener(this);
		tab6.setOnClickListener(this);
		tab7.setOnClickListener(this);
		tab8.setOnClickListener(this);

		tab1.setEnabled(false);
	}

	@Override
	public void onClick(View v) {
		updateFootView(v);

	}

	public static void updateFootView(View v) {
		if (v == tab1) {
			tab1.setEnabled(false);
		} else {
			tab1.setEnabled(true);
		}

		if (v == tab2) {
			tab2.setEnabled(false);
		} else {
			tab2.setEnabled(true);
		}

		if (v == tab3) {
			tab3.setEnabled(false);
		} else {
			tab3.setEnabled(true);
		}

		if (v == tab4) {
			tab4.setEnabled(false);
		} else {
			tab4.setEnabled(true);
		}

		if (v == tab5) {
			tab5.setEnabled(false);
		} else {
			tab5.setEnabled(true);
		}

		if (v == tab6) {
			tab6.setEnabled(false);
		} else {
			tab6.setEnabled(true);
		}
		if (v == tab7) {
			tab7.setEnabled(false);
		} else {
			tab7.setEnabled(true);
		}
		if (v == tab8) {
			tab8.setEnabled(false);
		} else {
			tab8.setEnabled(true);
		}

	}
}
