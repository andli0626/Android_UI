package com.andli.ui.customdemo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.epoint.android.customui.test.CustomButton;
import com.epoint.android.customui.topbar.FrameTopBar;

public class TestView extends Activity {
	CustomButton customView;
	Button leftButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 消除状态栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// 强制竖屏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// 键盘默认隐藏
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		setContentView(R.layout.testview);
		
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		FrameTopBar topbar = new FrameTopBar(this);
		LinearLayout topbarLayout = (LinearLayout) findViewById(R.id.topbarLayout);
		topbar.getToptitleTextView().setText("测试标题");
		topbarLayout.addView(topbar, params);

		

		// leftButton = topbar.getLeftButton();
		// leftButton.setText("");
		// leftButton.setTextSize(10);
		// leftButton.setBackgroundResource(R.drawable.frame_topbar_leftbutton);

	}
}