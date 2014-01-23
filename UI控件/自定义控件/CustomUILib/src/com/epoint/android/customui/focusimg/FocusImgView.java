package com.epoint.android.customui.focusimg;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.epoint.android.customui.help.CustomHelp;

/**
 * 
 * @author lilin
 * @date 2012-12-14 上午11:12:50
 * @annotation 焦点图控件：自定义
 */
public class FocusImgView extends FrameLayout {
	List<FocusImgInfo> focusImgInfos = new ArrayList<FocusImgInfo>();

	// Gallery
	private FocusImgGallery mFocusImgGallery;

	// 底部View

	public static TextView focusimg_title;

	private LinearLayout focusimg_indexLayout;
	public static ImageView[] indexImageViews;// 下标

	Context context;

	public FocusImgView(Context context, String _titles[], int _imgs[]) {
		super(context);
		this.context = context;
		Resources res = getResources();
		for (int i = 0; i < _titles.length; i++) {
			Bitmap bmp = BitmapFactory.decodeResource(res, _imgs[i]);
			FocusImgInfo mFocusImgInfo = new FocusImgInfo();
			mFocusImgInfo.setBitmap(bmp);
			mFocusImgInfo.setText(_titles[i]);
			focusImgInfos.add(mFocusImgInfo);
		}
		initUI(_titles.length);
	}

	public FocusImgView(Context context, String _titles[], Bitmap _imgs[]) {
		super(context);
		this.context = context;

		for (int i = 0; i < _titles.length; i++) {
			FocusImgInfo mFocusImgInfo = new FocusImgInfo();
			mFocusImgInfo.setBitmap(_imgs[i]);
			mFocusImgInfo.setText(_titles[i]);
			focusImgInfos.add(mFocusImgInfo);
		}
		initUI(_titles.length);
	}

	public FocusImgView(Context context) {
		super(context);
		this.context = context;

		String imgnames[] = { "test1.png", "test2.png", "test3.png",
				"test4.png", "test5.png" };
		Drawable[] drawables = CustomHelp.getImgsFromAsserts(context, imgnames);
		String titles[] = { "“2012金秋颂华章”在天坛世纪广场举行", "2012年世界游泳锦标赛奋力的拼搏",
				"太空探索进入新的纪元：采用太空热气球", "杭州地铁无故停运30分钟 官方未解释",
				"巴西举办趣味色彩赛跑 选手个个变彩人" };

		for (int i = 0; i < imgnames.length; i++) {
			BitmapDrawable bd = (BitmapDrawable) drawables[i];
			FocusImgInfo mFocusImgInfo = new FocusImgInfo();
			mFocusImgInfo.setBitmap(bd.getBitmap());
			mFocusImgInfo.setText(titles[i]);
			focusImgInfos.add(mFocusImgInfo);
		}

		initUI(titles.length);

	}

	public FocusImgView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;

		// initUI();
	}

	LinearLayout bottomLayout;

	private void initUI(int nums) {

		// Gallery
		mFocusImgGallery = new FocusImgGallery(context, focusImgInfos);
		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.FILL_PARENT,
				android.view.ViewGroup.LayoutParams.FILL_PARENT);
		// layoutParams.bottomMargin = 20;
		this.addView(mFocusImgGallery, layoutParams);
		layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.FILL_PARENT,
				30);
//		layoutParams.setMargins(0, 170, 0, 0);

		// 底部View
		bottomLayout = new LinearLayout(context);

		LinearLayout.LayoutParams titleparams = new LinearLayout.LayoutParams(
				200, LayoutParams.WRAP_CONTENT);
		titleparams.setMargins(10, 0, 0, 0);

		focusimg_title = new TextView(context);
		focusimg_title.setTextColor(Color.WHITE);
		focusimg_title.setTextSize(14);
		focusimg_title.setSingleLine();
		focusimg_title.setTypeface(focusimg_title.getTypeface(), Typeface.BOLD);

		bottomLayout.addView(focusimg_title, titleparams);

		focusimg_indexLayout = new LinearLayout(context);

		// bottomLayout.addView(focusimg_title, params);

		indexImageViews = new ImageView[nums];
		focusimg_indexLayout.removeAllViews();
		focusimg_indexLayout.setWeightSum(nums);
//		focusimg_indexLayout.setGravity(Gravity.CENTER_HORIZONTAL);
		focusimg_indexLayout.setOrientation(LinearLayout.HORIZONTAL);

		for (int i = 0; i < nums; i++) {
			indexImageViews[i] = new ImageView(context);
			if (i == 0)
				indexImageViews[i]
						.setBackgroundDrawable(CustomHelp.getImgFromAsserts(
								context, "focusimg_select_focus.png"));
			else
				indexImageViews[i].setBackgroundDrawable(CustomHelp
						.getImgFromAsserts(context,
								"focusimg_select_default.png"));
			focusimg_indexLayout.addView(indexImageViews[i], new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		}

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		params.setMargins(10, 0, 0, 0);

		bottomLayout.addView(focusimg_indexLayout, params);

		this.addView(bottomLayout);

	}
}
