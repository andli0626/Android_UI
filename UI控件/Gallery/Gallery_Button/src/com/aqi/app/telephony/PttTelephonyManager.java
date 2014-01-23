package com.aqi.app.telephony;
/*package com.ceict.PttPhone.telephony;

import java.util.regex.Pattern;

import com.zdzt.android.telephony.IPttTelephony;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class PttTelephonyManager {
	private static PttTelephonyManager mTelManager = null;
	final static String LOG_TAG="TestCaseTelephonyBasic";
	private static IPttTelephony pttTelephony = null;
	
	private static final int TIME_OUT_GENERAL = 5000;
	private PttStateListenerManager mManagerListener = null;

	
	private PttTelephonyManager(){
		mManagerListener = new PttStateListenerManager();
		try {
			pttTelephony.registerListener(mManagerListener.callback);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	*//**
	 * Get the Ptt Telephony Manager
	 * @return instance of Ptt Telephony Manager
	 *//*
	public static PttTelephonyManager getInstance(){
		if(mTelManager != null) return mTelManager;
		
		pttTelephony = IPttTelephony.Stub.asInterface(ServiceManager.getService("pttTelSvc"));
		if(pttTelephony == null){
			return null;
		}else{
			mTelManager = new PttTelephonyManager();			
			return mTelManager;
		}
	}
	
	*//**
	 * Get the Ptt Telephony service interface
	 * TODO:will make it private before release
	 * @return the instance of interface
	 *//*
	public IPttTelephony getTelephony(){
		return pttTelephony;
	}
	
	*//**
	 * register the listener to manager
	 * @param listener
	 *//*
	public void addListener(IAppPttTelephonyStateListener listener){
		this.mManagerListener.addListener(listener);
	}
	
	*//**
	 * unregister the listener to manager
	 * @param listener
	 *//*
	public void removeListener(IAppPttTelephonyStateListener listener){
		this.mManagerListener.removeListener(listener);
	}
	
	*//**
	 * Test the basic function of our extension
	 * @return
	 *//*
	public String testOemCmd(){
		String response = sendCommandGeneral("AT+XTESTOEMCMD", TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			return resArray[1];
		}else{
			return resArray[0];
		}
	}
	
	*//**
	 * NOTES: must take care of the time of get response to avoid ANR
	 *        if so, please move this to listener
	 * @param response
	 * @return
	 *//*
	public int analysisResponseOfCallGroup(String response){
		int result = 0;
		int cause = 0;
		if(response == null) return -1;
		
		String[] results = this.splitString(response);
		if(results == null || results.length < 2){
			return -1;
		}
		
		//first is result, second is cause reason
		//result = Integer.parseInt(results[0]);             li_write_[0]
		result = Integer.parseInt(results[1]);
		if(result != 0){
			cause = Integer.parseInt(results[1]);
		}
		Log.d(LOG_TAG, "Get response of call group (" + result + "," + cause +")");
		//high bits is result, and the lower is the cause.
		return (result<<3) | cause;
	}
	
	*//**
	 * Make a group call
	 * @param groupId the id of the group
	 * @return the result of the dialing request
	 *//*
	public int callGroup(String groupId){
		String cmd = "AT+XTGC=1,"+ groupId + ",0";
		String aa= sendCommandGeneral(cmd, TIME_OUT_GENERAL);
		System.out.println("CCCCC    "+analysisResponseOfCallGroup(aa));
		return analysisResponseOfCallGroup(sendCommandGeneral(cmd, TIME_OUT_GENERAL));

	}
	
	*//**
	 * hang up a group call
	 * @param
	 * @return the result of the hang up a group call
	 *//*
	public String HangUpGroupCall(){
		String cmd = "AT+XTGD";
		String response = sendCommandGeneral(cmd, TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			System.out.println("hangup Group_Call   "+resArray[1]);
			return resArray[1];
		}else{
			System.out.println("hangup Group_Call   "+resArray[0]);
			return resArray[0];
		}
	}
	*//**
	 * relase group call
	 * *//*
	public String RelaseCall(){
		String cmd = "AT+XTPPR";
		String response = sendCommandGeneral(cmd, TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			System.out.println("relase Group_Call   "+resArray[1]);
			return resArray[1];
		}else{
			System.out.println("relase Group_Call   "+resArray[0]);
			return resArray[0];
		}
	}
	
	public String ResponseGroupCall(String cmd){
		String response = sendCommandGeneral(cmd, TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			System.out.println("answer Group call   " + resArray[1]);
			return resArray[1];
		}else{
			System.out.println("answer Group call   " + resArray[0]);
			return resArray[0];
		}
	}
	*//**
	 * getGroupID
	 * *//*
	public String getGroupID(){
		String cmd="AT+XTGID";
		String response = sendCommandGeneral(cmd, TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			return resArray[1];
		}else{
			return resArray[0];
		}
	}
	*//**
	 * 缁勮韩浠界爜  
	 * *//*
	
	public String getGroupCode(){
		String cmd="AT+XTSGID";
		String response = sendCommandGeneral(cmd, TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			System.out.println("get_Group_Code   " + resArray[1]);
			return resArray[1];
		}else{
			System.out.println("get_Group_Code   " + resArray[0]);
			return resArray[0];
		}
	}
	
	*//**
	 * 閫夌粍閫氱煡   閫夌粍閫氱煡 AT+XTCGID锛�	 * *//*
	public String getGroupNotice(){
		String cmd="AT+XTCGID";
		String response = sendCommandGeneral(cmd, TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			System.out.println("get_Group_Notice   " + resArray[1]);
			return resArray[1];
		}else{
			System.out.println("get_Group_Notice   " + resArray[0]);
			return resArray[0];
		}
	}
	
	
	*//**
	 * Get the Mac address of the MEM modem
	 * @return Mac address
	 *//*
	public String getMacAddress(){
		String response = sendCommandGeneral("AT+XMAC", TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		if(resArray.length > 1){
			System.out.println("get_Mac_address    "+resArray[1]);
			return resArray[1];
			
		}else{
			System.out.println("get_Mac_address   "+resArray[0]);
			return resArray[0];
		}
	}
	
	*//**
	 * Get the Ip address of the MEM modem
	 * @return Ip address
	 *//*
	public String getIpAddress(){
		String response = sendCommandGeneral("AT+XLOCALIP", TIME_OUT_GENERAL);
		String[] resArray = splitString(response);
		System.out.println("aaaaaaaaa   "+ resArray.length);
		if(resArray.length > 1){
			System.out.println("get_ip_address   "+resArray[1]);
			return resArray[1];
		}else{
			System.out.println("get_ip_address   "+resArray[0]);
			return resArray[0];
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
	
	*//**
	 * Send general command
	 * @param cmd
	 * @return
	 *//*
	private String sendCommandGeneral(String cmd, int timeout){
		try {
			return pttTelephony.sendOemCommand(cmd, timeout);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
*/