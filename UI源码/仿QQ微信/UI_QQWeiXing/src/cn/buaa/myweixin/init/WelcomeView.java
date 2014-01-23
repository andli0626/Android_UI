package cn.buaa.myweixin.init;

import cn.buaa.myweixin.R;
import cn.buaa.myweixin.R.layout;
import cn.buaa.myweixin.login.LoginView;
import cn.buaa.myweixin.main.MainView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
	}

	public void welcome_login(View v) {
		Intent intent = new Intent();
		intent.setClass(WelcomeView.this, LoginView.class);
		startActivity(intent);
	}

	public void welcome_register(View v) {
		Intent intent = new Intent();
		intent.setClass(WelcomeView.this, MainView.class);
		startActivity(intent);
	}

}
