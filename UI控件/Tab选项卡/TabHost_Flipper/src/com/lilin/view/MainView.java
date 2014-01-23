package com.lilin.view;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.OnTabChangeListener;

import com.lilin.ui.MyTabHost;

public class MainView extends TabActivity implements OnTabChangeListener,
		OnGestureListener {
	// 底部RadioGroup
	private RadioGroup radioGroup_Bottom;
	private RadioGroup radioGroup = null;
	private GestureDetector gestureDetector;
	@SuppressWarnings("unused")
	private FrameLayout frameLayout;
	private MyTabHost tabHost;
	private TabWidget tabWidget;
	public static final String TAB1 = "0";
	public static final String TAB2 = "1";
	public static final String TAB3 = "2";
	public static final String TAB4 = "3";
	// 滑动距离：调整滑动的速度
	private static final int FLEEP_DISTANCE = 50;

	/** 记录当前分页ID */
	private int curTabID = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);

		initView();
		gestureDetector = new GestureDetector(this);
		new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (gestureDetector.onTouchEvent(event)) {
					return true;
				}
				return false;
			}
		};
		frameLayout = tabHost.getTabContentView();
	}

	private void initView() {
		tabHost = (MyTabHost) findViewById(android.R.id.tabhost);
		tabWidget = (TabWidget) findViewById(android.R.id.tabs);
		tabHost.setOnTabChangedListener(this);
		tabHost.addTab(tabHost.newTabSpec("0").setIndicator(TAB1).setContent(
				new Intent(this, TabView1.class)));
		tabHost.addTab(tabHost.newTabSpec("1").setIndicator(TAB2).setContent(
				new Intent(this, TabView2.class)));
		tabHost.addTab(tabHost.newTabSpec("2").setIndicator(TAB3).setContent(
				new Intent(this, TabView3.class)));
		tabHost.addTab(tabHost.newTabSpec("3").setIndicator(TAB4).setContent(
				new Intent(this, TabView4.class)));
		// setIndicator(R.drawable.icon1, 0, new Intent(this,
		// TabActivity01.class));
		// setIndicator(R.drawable.icon2, 1, new Intent(this,
		// TabActivity02.class));
		// setIndicator(R.drawable.icon3, 2, new Intent(this,
		// TabActivity03.class));
		// setIndicator(R.drawable.icon4, 3, new Intent(this,
		// TabActivity04.class));

		radioGroup_Bottom = (RadioGroup) findViewById(R.id.main_radio);

		radioGroup_Bottom
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						switch (checkedId) {
						case R.id.radio_button0:
							tabHost.setCurrentTabByTag(TAB1);
							radioGroup.check(0);
							break;
						case R.id.radio_button1:
							radioGroup.check(1);
							tabHost.setCurrentTabByTag(TAB2);
							break;
						case R.id.radio_button2:
							radioGroup.check(2);
							tabHost.setCurrentTabByTag(TAB3);
							break;
						case R.id.radio_button3:
							radioGroup.check(3);
							tabHost.setCurrentTabByTag(TAB4);
							break;
						default:
							break;
						}
					}
				});
		radioGroup = (RadioGroup) findViewById(R.id.home_advs_gallery_mark);
		// 根据图片的个数动态添加RadioButton
		for (int i = 0; i < 4; i++) {
			RadioButton radioButton = new RadioButton(MainView.this);
			radioButton.setId(i);
			radioButton.setButtonDrawable(R.drawable.adv_gallery_mark_selector);
			radioButton.setClickable(false);
			// radioButton.setWidth(40);
			radioButton.setGravity(Gravity.CENTER);
			radioGroup.addView(radioButton);
		}
		radioGroup.check(0);
	}

	@SuppressWarnings("unused")
	private void setIndicator(int icon, int tabId, Intent intent) {
		View localView = LayoutInflater.from(this.tabHost.getContext())
				.inflate(R.layout.tabitem, null);
		((ImageView) localView.findViewById(R.id.tab_image))
				.setBackgroundResource(icon);
		String str = String.valueOf(tabId);
		// 改变系统自带的tab样式：使用ImageView重新设置
		TabHost.TabSpec localTabSpec = tabHost.newTabSpec(str).setIndicator(
				localView).setContent(intent);
		tabHost.addTab(localTabSpec);
	}

	@Override
	public void onTabChanged(String tabId) {
		// tabId值为要切换到的tab页的索引位置
		int tabID = Integer.valueOf(tabId);
		for (int i = 0; i < tabWidget.getChildCount(); i++) {
			if (i == tabID) {
				tabWidget.getChildAt(Integer.valueOf(i)).setBackgroundColor(
						R.color.bule);
			} else {
				tabWidget.getChildAt(Integer.valueOf(i)).setBackgroundColor(
						R.color.white);
			}
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) {
			event.setAction(MotionEvent.ACTION_CANCEL);
		}
		return super.dispatchTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e1.getX() - e2.getX() <= (-FLEEP_DISTANCE)) {// 从左向右滑动
			curTabID = tabHost.getCurrentTab() - 1;
			if (curTabID < 0) {
				curTabID = tabHost.getTabCount() - 1;
			}
		} else if (e1.getX() - e2.getX() >= FLEEP_DISTANCE) {// 从右向左滑动
			curTabID = tabHost.getCurrentTab() + 1;
			if (curTabID >= tabHost.getTabCount()) {
				curTabID = 0;
			}
		}
		tabHost.setCurrentTab(curTabID);
		radioGroup.check(curTabID);
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}
}