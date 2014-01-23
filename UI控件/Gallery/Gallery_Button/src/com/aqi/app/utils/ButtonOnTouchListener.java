package com.aqi.app.utils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.aqi.app.ui.MainActivity;

public class ButtonOnTouchListener implements OnTouchListener{

	MainActivity myActivity = null;
	public ButtonOnTouchListener(){}
	public ButtonOnTouchListener(MainActivity myactivity){
		this.myActivity = myactivity;
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_UP:
			break;
		default:
			break;
		}
		return false;
	}

}
