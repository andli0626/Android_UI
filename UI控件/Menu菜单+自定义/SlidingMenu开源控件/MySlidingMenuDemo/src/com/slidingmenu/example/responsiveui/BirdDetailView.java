package com.slidingmenu.example.responsiveui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.actionbarsherlock.app.SherlockActivity;
import com.slidingmenu.example.R;

public class BirdDetailView extends SherlockActivity {

	public static Intent newInstance(Activity activity, int pos) {
		Intent intent = new Intent(activity, BirdDetailView.class);
		intent.putExtra("pos", pos);
		return intent;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int pos = 0;
		if (getIntent().getExtras() != null) {
			pos = getIntent().getExtras().getInt("pos");
		}

		String[] birds = getResources().getStringArray(R.array.birds);
		TypedArray imgs = getResources().obtainTypedArray(R.array.birds_img);
		int resId = imgs.getResourceId(pos, -1);

		setTitle(birds[pos]);

		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);

		ColorDrawable color = new ColorDrawable(Color.BLACK);
		color.setAlpha(128);

		ImageView imageView = new ImageView(this);
		imageView.setScaleType(ScaleType.CENTER_INSIDE);
		imageView.setImageResource(resId);
		setContentView(imageView);

	}

}
