package com.aqi.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class CeictLuncher extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		
		setContentView(R.layout.ceict_luncher);
 
 
		new Handler().postDelayed(new Runnable() {
			public void run() {
				/* Create an Intent that will start the Main Activity. */
				Intent mainIntent = new Intent(CeictLuncher.this,
						MainActivity.class);
				CeictLuncher.this.startActivity(mainIntent);
				CeictLuncher.this.finish();
			}
		}, 2500);
	}
}
