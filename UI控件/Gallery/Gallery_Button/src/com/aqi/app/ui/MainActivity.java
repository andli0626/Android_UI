package com.aqi.app.ui;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aqi.app.adapter.GalleryFlow;
import com.aqi.app.adapter.ImageAdapter;
import com.aqi.app.base.CeictApplication;
import com.aqi.app.db.PttSharedPreferences;
import com.aqi.app.utils.ButtonOnClickListener;
import com.aqi.app.utils.ButtonOnTouchListener;

public class MainActivity extends Activity {
	
	public ImageButton imageButton,group_location_left,group_location_right= null;
    public TextView phone_state = null;
    public Button group_call,answer_group_call,hangup_group_call,relase_group_call,getGroupCode,getGroupNotice,
    getIpAdress,getMacAdress= null;
    public ButtonOnClickListener  myListener = null;
    public ButtonOnTouchListener buttonOnTouchListener = null;
    public  String flag;
    public PttSharedPreferences pttSharedPreferences = null;
    public  GalleryFlow galleryFlow = null;
    public ImageAdapter adapter = null;
    public Gallery gallery = null;
    
    public static boolean ceict_flag;
    public CeictApplication ceictApplication = null;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
		setListener();
	}
	public void init(){
		
		ceictApplication = 	(CeictApplication)getApplication();
		myListener =new ButtonOnClickListener(MainActivity.this);
		
		
		pttSharedPreferences = new PttSharedPreferences(MainActivity.this);
		buttonOnTouchListener = new ButtonOnTouchListener(MainActivity.this);
		
		
		group_location_left = (ImageButton) findViewById(R.id.group_location_left);
		group_location_right = (ImageButton) findViewById(R.id.group_location_right);
		
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//View layout =  inflater.inflate(R.layout.layout_gallery, null);
		Integer images[]  = { R.drawable.img0001, R.drawable.img0030,
                R.drawable.img0100, R.drawable.img0130, R.drawable.img0200,
                R.drawable.img0230, R.drawable.img0300, R.drawable.img0330,
                R.drawable.img0354 };
        
        adapter = new ImageAdapter(this, images);
        adapter.createReflectedImages();

        galleryFlow = (GalleryFlow) findViewById(R.id.gallery);
        galleryFlow.setAdapter(adapter);
       
		
	}
	public void setListener(){
		
		group_location_left.setOnClickListener(myListener);
		group_location_right.setOnClickListener(myListener);
	}
	
	/**
	 * 实现讲话图片的瞬间变�?	 * */
	public void imageButtonSetBackground(){
		
		
	}
	
	/**
	 * �? 组的数字保存到SharedPreferences�?	 * */
	public void saveGroupNumOnSharedPreferences(){
		pttSharedPreferences.savePreferences();
	}
	/**
	 * �? 保存的组的信息加载得�?	 * */
	public void loadGroupNumOnSharedPreferences(){
		pttSharedPreferences.loadPreferences();
	}
} 