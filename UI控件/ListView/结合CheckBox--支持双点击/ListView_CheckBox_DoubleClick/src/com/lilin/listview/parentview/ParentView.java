package com.lilin.listview.parentview;

import com.lilin.listview.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;


/**
 * 普通页通用页面
 * 
 * @author liyc
 */
public abstract class ParentView extends BaseView implements
		OnClickListener {
	public RelativeLayout mainFrame;
	public LayoutInflater inflater;
	public RelativeLayout.LayoutParams params;
	public RelativeLayout topmenu;
	public int layoutpage;
	/* 顶部菜单 */
	public Button tBack_btn;// 返回按钮
	public Button tMenu_btn;// 菜单按钮
	public TextView title_txt;// 标题

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/* 渲染主窗体 */
		inflater = LayoutInflater.from(ParentView.this);
		layoutpage = getLayoutInt();
		mainFrame = (RelativeLayout) inflater.inflate(layoutpage, null);
		params = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);

		this.addContentView(mainFrame, params);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		// 设置背景色
		setBackground();

		/* 主窗体中添加公共的顶部菜单 */
		topmenu = (RelativeLayout) inflater.inflate(R.layout.topmenu, null);

		mainFrame.addView(topmenu, params);
		title_txt = (TextView) findViewById(R.id.title_text);// 获得标题对象
		title_txt.setText(setTitle());
		tBack_btn = (Button) findViewById(R.id.topback_btn);// 获得返回按钮对象
		tBack_btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		tMenu_btn = (Button) findViewById(R.id.topemenu_btn);// 获得菜单按钮对象
		tMenu_btn.setVisibility(View.GONE);
		initControls();
	}

	/**
	 * 初始化控件
	 */
	public abstract void initControls();

	/**
	 * 获取页面布局文件，注意不是通用布局文件
	 */
	public abstract int getLayoutInt();

	public void setBackground() {
		mainFrame.setBackgroundResource(R.drawable.background);
	}

	/**
	 * 通用菜单右边按钮标签
	 * 
	 * @return
	 */
	public String getTopRightButtonLabel() {
		return "";
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			KEYCODE_BACK();
			break;
		}
		return false;
	}

	/**
	 * 返回按钮事件
	 */
	public void KEYCODE_BACK() {
		finish();
	}

	/**
	 * 返回标题
	 */
	public String setTitle() {
		return "";
	};

}
