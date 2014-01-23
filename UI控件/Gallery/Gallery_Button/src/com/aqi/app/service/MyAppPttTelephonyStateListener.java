package com.aqi.app.service;

import android.util.Log;

import com.aqi.app.telephony.IAppPttTelephonyStateListener;

public class MyAppPttTelephonyStateListener implements
		IAppPttTelephonyStateListener {
	private static final String TAG = "MyAppPttTelephonyStateListener";
	
	public boolean onTestOemCommandResponse_called = false;
	@Override
	public void onTestOemCommandResponse(String report) {
		Log.d(TAG, "onTestOemCommandResponse report " + report);
		if(report.equals("TESTOK")){
			onTestOemCommandResponse_called = true;
		}
	}

}
