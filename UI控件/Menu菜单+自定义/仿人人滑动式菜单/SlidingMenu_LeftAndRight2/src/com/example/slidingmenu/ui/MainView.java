package com.example.slidingmenu.ui;

import com.example.slidingmenu.R;
import com.example.slidingmenu.lib.SlidingMenu;
import com.example.slidingmenu.lib.SlidingView.OnScrollCloseListener;
import com.example.slidingmenu.lib.SlidingView.OnScrollOpenListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;

public class MainView extends FragmentActivity {
	SlidingMenu mSlidingMenu;
	LeftFragment leftFragment;
	RightFragment rightFragment;
	CenterFragment centerFragment;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.mainview);

		// 根据屏幕大小 按比例计算 图片的高度
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);

		mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		
		mSlidingMenu.setAlignScreenWidth((dm.widthPixels / 5) * 4);
		
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.left_frame, null));
		
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.right_frame, null));
		
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.center_frame, null));

		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		leftFragment = new LeftFragment();
		t.replace(R.id.left_frame, leftFragment);

		rightFragment = new RightFragment();
		t.replace(R.id.right_frame, rightFragment);

		centerFragment = new CenterFragment();
		t.replace(R.id.center_frame, centerFragment);
		t.commit();
	}

	public void showLeft() {
		mSlidingMenu.showLeftView();
	}

	public void showRight() {
		mSlidingMenu.showRightView();
	}

	public void showCenter() {
		mSlidingMenu.showCenterView();
	}

	public void setOnScrollOpenListener(OnScrollOpenListener onScrollEndListener) {
		mSlidingMenu.setOnScrollOpenListener(onScrollEndListener);
	}

	public void setOnScrollCloseListener(
			OnScrollCloseListener mOnScrollCloseListener) {
		mSlidingMenu.setOnScrollCloseListener(mOnScrollCloseListener);
	}
}
