package com.yangyu.mytitlebar01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * @author yangyu 功能描述：第二种实现方式,Activity实现方式
 */
public class TestView2 extends Activity {
	// 定义标题栏上的按钮
	private ImageButton titleBtn;

	TextView title_txt;

	public static String title = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);

		initView();
	}

	@Override
	protected void onResume() {
		title_txt = (TextView) findViewById(R.id.title_txt);
		if (title.length() > 0) {
			title_txt.setText(title);
		}
		super.onResume();
	}

	/**
	 * 初始化组件
	 */
	private void initView() {
		// 实例化标题栏按钮并设置监听
		titleBtn = (ImageButton) findViewById(R.id.title_btn);
		titleBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(TestView2.this, DialogListView.class));
			}
		});

	}

}
