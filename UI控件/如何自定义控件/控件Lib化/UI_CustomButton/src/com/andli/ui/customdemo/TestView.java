package com.andli.ui.customdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

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
		
	}
}