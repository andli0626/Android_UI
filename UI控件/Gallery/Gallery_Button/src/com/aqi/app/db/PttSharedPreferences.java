package com.aqi.app.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.aqi.app.ui.MainActivity;

public class PttSharedPreferences{
  public static final String PREFERENCES_NAME = "GroupNumPreferences";
  public static int MODE = Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE ;
  public MainActivity myActivity = null;
  SharedPreferences sharedPreferences = null;
  Editor editor  = null;
  
  
  /**
   * Constructor of PttSharedPreferences
   * @param Context 
   * */
  public PttSharedPreferences(){}
  public PttSharedPreferences(Context context){
	  
	  System.out.println("PttSharedPreferences ");
	  this.myActivity = (MainActivity) context;
  }
  /**
   * 保存sharePreferences
   * 
   * */
  public void savePreferences(){
	 sharedPreferences = myActivity.getSharedPreferences(PREFERENCES_NAME,MODE);
	 editor = sharedPreferences.edit();
	 editor.putString("group_first_num", myActivity.phone_state.getText().toString());
	 
	 editor.commit();
  }
  
  /**
   * 加载sharePreferences
   * */
  public void loadPreferences(){
	  sharedPreferences = myActivity.getSharedPreferences(PREFERENCES_NAME, MODE);
	  String aa = sharedPreferences.getString("group_first_num","default");
	  System.out.println("aa ----->  "+aa);
  }
}
