package com.lilin.test;
import android.app.Activity;
import android.os.Bundle;

public class Tab2 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		
		SmiliesEditText et = (SmiliesEditText)findViewById(R.id.EditText1);
		et.append("hello");
		et.insertIcon(R.drawable.icon);
		String s = et.getText().toString();
		System.out.println(s);
	}
}
