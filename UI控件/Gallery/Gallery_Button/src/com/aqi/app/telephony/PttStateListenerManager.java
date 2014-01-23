package com.aqi.app.telephony;
/*package com.ceict.PttPhone.telephony;

//import java.util.LinkedList;
import java.util.regex.Pattern;

import com.zdzt.android.telephony.PttTelephonyStateListener;

import android.util.Log;

public class PttStateListenerManager extends PttTelephonyStateListener {
	
	private static final String LOG_TAG = "ManagerPttStateListener";
	
	//maybe over designed, use on listener only
	//private LinkedList<IAppPttTelephonyStateListener> mListenList = null;
	
	private IAppPttTelephonyStateListener mListener = null;
	
	*//**
	 * register the listener to manager
	 * @param listener
	 *//*
	public void addListener(IAppPttTelephonyStateListener listener){		
		if(mListenList == null){
			mListenList = new LinkedList<IAppPttTelephonyStateListener>();
		}
		if(mListenList.contains(listener)){
			Log.d(LOG_TAG, "duplicate to register listener");
			return;
		}else{
			Log.d(LOG_TAG, "register listener " + listener);
			mListenList.add(listener);
		}
		mListener = listener;
	}
	
	*//**
	 * unregister the listener to manager
	 * TODO: maybe over designed, keep here for future
	 * @param listener
	 *//*
	public void removeListener(IAppPttTelephonyStateListener listener){		
		if(mListenList == null){
			return;
		}
		if(mListenList.contains(listener)){
			Log.d(LOG_TAG, "unregister listener " + listener);
			mListenList.remove(listener);
		}
	}
	
	*//**
	 * override me to handle the unsol command, :)
	 * @param command, the command you are interested
	 *//*
	public void onUnsolOemCommand(String command){
		Log.d(LOG_TAG, "Get command " + command);
		if(mListener == null){
			Log.d(LOG_TAG, "Get command " + command + ", but no listener");
		}
		String[] cmds = splitString(command);
		if(cmds == null || cmds.length < 1) return;
		if(cmds[0].compareTo("+XTESTOMECMD") == 0){
			for(IAppPttTelephonyStateListener listener : mListenList){
				listener.onTestOemCommandResponse(cmds[1]);
			}
			Log.d(LOG_TAG, "I tell you, we got test omd report " + cmds[1]);
			mListener.onTestOemCommandResponse(cmds[1]);
		}
	}
	
	*//**
	 * split one string by a character
	 * @param response
	 * @return
	 *//*
	private String[] splitString(String response){
		Pattern pattern = Pattern.compile("[:,]+");
		String[] strs = pattern.split(response);
		return strs;
	}
}
*/