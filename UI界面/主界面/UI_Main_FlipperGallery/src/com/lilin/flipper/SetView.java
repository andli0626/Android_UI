package com.lilin.flipper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.droidful.flinggallery.R;


/**
 * 设置界面
 * 
 * @author lilin
 * @date 2011-12-13 上午12:06:03
 * @ClassName: SettingsActivity
 */
public class SetView extends PreferenceActivity {

	public static void launch(Context c) {
		Intent intent = new Intent(c, SetView.class);
		c.startActivity(intent);
	}

	public void onCreate(Bundle savedInstanceState) {
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		// 增加preferences
		addPreferencesFromResource(R.xml.preferences);
		// 再设置视图
		setContentView(R.layout.setview);
		setTitle("系统设置");
	}

}