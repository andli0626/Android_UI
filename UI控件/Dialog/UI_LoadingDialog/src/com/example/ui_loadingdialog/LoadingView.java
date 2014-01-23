package com.example.ui_loadingdialog;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class LoadingView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loadingview);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				// Intent intent = new Intent(LoadingView.this, Whatsnew.class);
				// startActivity(intent);
				// LoadingView.this.finish();
				// Toast.makeText(getApplicationContext(), "登录成功",
				// Toast.LENGTH_SHORT).show();
				finish();
			}
		}, 5000);
	}
}