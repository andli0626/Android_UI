package com.df.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.df.dianping.R;

/**
 * 
 * @author lilin
 * @date 2012-12-6 下午5:13:03
 * @annotation 初始化界面
 */
public class DZDP_InitView extends Activity {
	private final int TIME_UP = 1;

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.dzdp_initview);

		new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				Message msg = new Message();
				msg.what = TIME_UP;
				handler.sendMessage(msg);
			}
		}.start();

	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == TIME_UP) {

				Intent intent = new Intent();
				intent.setClass(DZDP_InitView.this, DZDP_MainView.class);
				startActivity(intent);

				overridePendingTransition(R.anim.splash_screen_fade,R.anim.splash_screen_hold);// 动画效果

				finish();
			}
		}
	};
}