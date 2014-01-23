package com.andli.uitest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class UITestActivity extends Activity {

	LinearLayout linearLayout;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LoadingDialog loadDialog = new LoadingDialog(this);
		loadDialog.setLoadText("测试加载...");
		loadDialog.show();

	}
}