package com.andli.ui.focusimg;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;

public class TestView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		addFocusImagView();

	}

	// 添加焦点图控件
	private void addFocusImagView() {
		// 要显示的图片
		int[] res = new int[] { R.drawable.t1, R.drawable.t2, R.drawable.t3,R.drawable.t4, R.drawable.t5, R.drawable.t6 };

		// 焦点图控件
		View focusImgView = LayoutInflater.from(this).inflate(R.layout.focusimgview, null);
		
		Gallery mGallery = (Gallery) focusImgView.findViewById(R.id.home_gallery);
		
		final FocusImgFlowIndicator mMyView = (FocusImgFlowIndicator) focusImgView.findViewById(R.id.myView);

		FocusImgGalleryAdp mFocusImgGalleryAdp = new FocusImgGalleryAdp(this, res);
		
		mMyView.setCount(mFocusImgGalleryAdp.getCount());
		mGallery.setAdapter(mFocusImgGalleryAdp);
		mGallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				mMyView.setSeletion(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		addContentView(focusImgView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

	}
}