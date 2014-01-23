package com.aqi.app.utils;

import android.view.View;
import android.widget.Toast;

import com.aqi.app.base.Contants;
import com.aqi.app.ui.MainActivity;
import com.aqi.app.ui.R;

public class ButtonOnClickListener implements View.OnClickListener{
	private MainActivity myActivity = null;
	public ButtonOnClickListener(){}
	public ButtonOnClickListener(MainActivity activity){
		this.myActivity =  activity;
		System.out.println("myActivity ButtonOnClickListener  ");
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.group_location_left:
			myActivity.galleryFlow.setSelection(--Contants.num);
			Toast.makeText(myActivity, " left ", Toast.LENGTH_LONG);
			break;
		case R.id.group_location_right:
			System.out.println("Contants.num  "+Contants.num);
			myActivity.galleryFlow.setSelection(++Contants.num);
			Toast.makeText(myActivity, " left ", Toast.LENGTH_LONG);
			break;
		default:
			break;
		}
	}
  
	
}
