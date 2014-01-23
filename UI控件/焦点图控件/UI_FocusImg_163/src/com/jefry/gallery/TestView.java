package com.jefry.gallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class TestView extends Activity {

	FocusImgView focusImgView;
	LinearLayout focusImgLayout;

	int imgs[] = { R.drawable.test1, R.drawable.test2, R.drawable.test3,
			R.drawable.test4, R.drawable.test5 };

	String titles[] = { "“2012金秋颂华章”在天坛世纪广场举行", "2012年世界游泳锦标赛奋力的拼搏",
			"太空探索进入新的纪元：采用太空热气球", "杭州地铁无故停运30分钟 官方未解释", "巴西举办趣味色彩赛跑 选手个个变彩人" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testview);

		focusImgLayout = (LinearLayout) findViewById(R.id.focusimgLayout);

		Bitmap bmps[] = new Bitmap[imgs.length];
		for (int i = 0; i < bmps.length; i++) {
			bmps[i] = BitmapFactory.decodeResource(getResources(), imgs[i]);
		}

		focusImgView = new FocusImgView(this, titles, bmps);
		
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		focusImgLayout.addView(focusImgView, params);
		
		

	}
}