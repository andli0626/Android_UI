package com.andli.uitest;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.TextView;

public class UITestActivity extends Activity {
	TextView mTextView = null;
	SpannableString msp = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	
	}
}