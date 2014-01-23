package com.ljp.ani;

import com.andli.widget.ShakeImageView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class TestView extends Activity {
	ShakeImageView mShakeImageView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mShakeImageView = (ShakeImageView) findViewById(R.id.c_joke);
		mShakeImageView.setOnClickIntent(new ShakeImageView.OnViewClick() {

			public void onClick() {
				Toast.makeText(TestView.this, "Click", 1000).show();
			}
		});
	}
}