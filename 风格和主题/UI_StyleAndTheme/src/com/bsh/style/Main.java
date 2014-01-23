package com.bsh.style;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	public static Main sf;
	public int theme = -1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		sf = this;
		//读取主题 如果读取失败，则设置为系统默认的主题
		theme = getSharedPreferences("cons", MODE_PRIVATE).getInt("theme", 
				android.R.style.Theme);
		//设定主题
		setTheme(theme);
		//调用父类方法，一定要放到设定主题之后
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btn = (Button) findViewById(R.id.btn1);
		
		//通过点击，切换主题。点击后要重起应用能看到效果
		btn.setOnClickListener( new OnClickListener(){

			@Override
			public void onClick(View v) {
				if( R.style.MyTheme1 != theme ){
					//将主题保存到sharedPreference中，以便下次启动设置主题时读取
					sf.getSharedPreferences("cons",Activity.MODE_PRIVATE).edit()
					.putInt("theme", R.style.MyTheme1).commit();
				} else {
					sf.getSharedPreferences("cons",Activity.MODE_PRIVATE).edit()
					.putInt("theme", R.style.MyTheme2).commit();					
				}
				//退出应用
				android.os.Process.killProcess(android.os.Process.myPid());
			}
			
		});
	}
}