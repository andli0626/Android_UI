package com.lilin.listview.parentview;

import com.lilin.listview.util.Util;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * 页面基类，必须继承
 * 
 * @author liyc
 */
public class BaseView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Util.alist.add(this);
	}
}
