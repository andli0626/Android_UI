package com.andli.ui.customdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.andli.ui.custombutton.CustomButton;

public class TestView extends Activity {
	CustomButton customView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testview);

		customView = (CustomButton) findViewById(R.id.customview);
		customView.setText("自定义按钮控件");
		customView.setBackgroundColor(Color.WHITE);

		TextView text = customView.getTextView();
		text.setText("确定");
		text.setTextColor(Color.RED);

		final ImageView imageView = customView.getImageView();
		imageView.setBackgroundResource(R.drawable.custombutton_default_normal);

		customView.setClickable(true);// 否则selector无法切换LinearLayout背景颜色
		customView.setBackgroundResource(R.drawable.custombutton_bg);

//		customView.setOnTouchListener(new OnTouchListener() {
//			public boolean onTouch(View v, MotionEvent event) {
//				if (event.getAction() == MotionEvent.ACTION_DOWN) {
//					imageView.setBackgroundResource(R.drawable.custombutton_default_press);
//				} else if (event.getAction() == MotionEvent.ACTION_UP) {
//					imageView.setBackgroundResource(R.drawable.custombutton_default_normal);
//				}
//				return false;
//			}
//		});

	}
}