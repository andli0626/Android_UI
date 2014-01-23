package com.yangyu.mytitlebar01;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

/**
 * @author yangyu 功能描述：弹出Activity界面
 */
public class DialogActivity extends Activity implements OnClickListener {
	private LinearLayout layout01, layout02, layout03, layout04;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);

		initView();
	}

	/**
	 * 初始化组件
	 */
	private void initView() {
		// 得到布局组件对象并设置监听事件
		layout01 = (LinearLayout) findViewById(R.id.llayout01);
		layout02 = (LinearLayout) findViewById(R.id.llayout02);
		layout03 = (LinearLayout) findViewById(R.id.llayout03);
		layout04 = (LinearLayout) findViewById(R.id.llayout04);

		layout01.setOnClickListener(this);
		layout02.setOnClickListener(this);
		layout03.setOnClickListener(this);
		layout04.setOnClickListener(this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		finish();
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v == layout01) {
			TestView2.title = "写跟帖";
			finish();
		} else if (v == layout02) {
			TestView2.title = "分享";
			finish();
		} else if (v == layout03) {
			TestView2.title = "收藏";
			finish();
		} else if (v == layout04) {
			TestView2.title = "字体大小";
			finish();
		}

	}
}
