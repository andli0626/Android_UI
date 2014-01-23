package com.andli.ui.customdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.andli.ui.custombutton.CustomButton;
import com.andli.ui.custombutton.CustomHelp;

public class TestView extends Activity {
	CustomButton customView;
	Button testButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testview);

		customView = (CustomButton) findViewById(R.id.customview);

//		customView.setBackgroundDrawable(CustomHelp.newSelector(this,
//				R.drawable.btn_blue_normal, R.drawable.btn_blue_press,
//				R.drawable.btn_blue_normal, R.drawable.btn_blue_normal));

	}

}