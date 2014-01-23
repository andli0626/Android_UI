package com.epoint.mobileui.focusimg;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.epoint.android.frameui.R;

/**
 * 
 * @author lilin
 * @date 2012-12-14 上午11:12:50
 * @annotation 焦点图控件：自定义
 */
public class FocusImgView extends FrameLayout {
	List<FocusImgInfo> focusImgInfos = new ArrayList<FocusImgInfo>();

	// Gallery
	public FocusImgGallery mFocusImgGallery;

	// 底部View

	public static TextView focusimg_title;

	private LinearLayout focusimg_indexLayout;
	public static ImageView[] indexIcons;// 下标

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

		int imgs[] = { R.drawable.test1, R.drawable.test2, R.drawable.test3,
				R.drawable.test4, R.drawable.test5 };
		String titles[] = { "“2012金秋颂华章”在天坛世纪广场举行", "2012年世界游泳锦标赛奋力的拼搏",
				"太空探索进入新的纪元：采用太空热气球", "杭州地铁无故停运30分钟 官方未解释",
				"巴西举办趣味色彩赛跑 选手个个变彩人" };

		for (int i = 0; i < imgs.length; i++) {
			Bitmap bmp = BitmapFactory.decodeResource(context.getResources(),
					imgs[i]);
			FocusImgInfo mFocusImgInfo = new FocusImgInfo();
			mFocusImgInfo.setBitmap(bmp);
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

	private void initUI(int nums) {

		// Gallery
		mFocusImgGallery = new FocusImgGallery(context, focusImgInfos);
		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.FILL_PARENT,
				android.view.ViewGroup.LayoutParams.FILL_PARENT);
		// layoutParams.bottomMargin = 20;
		this.addView(mFocusImgGallery, layoutParams);

		// 底部View
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		View bottomView = inflater.inflate(R.layout.focusimg_bottombar, null);
		this.addView(bottomView);

		focusimg_indexLayout = (LinearLayout) bottomView
				.findViewById(R.id.focusimg_bottombar_index_layout);
		focusimg_title = (TextView) bottomView
				.findViewById(R.id.focusimg_bottombar_title);
		focusimg_title.setTextColor(Color.WHITE);

		initBottomindexIcons(nums);

	}

	// 初始化底部滚动的：圆点图标
	private final void initBottomindexIcons(int indexIconsNums) {

		indexIcons = new ImageView[indexIconsNums];
		focusimg_indexLayout.removeAllViews();
		focusimg_indexLayout.setWeightSum(indexIconsNums);

		for (int i = 0; i < indexIconsNums; i++) {
			indexIcons[i] = new ImageView(context);
			if (i == 0)
				indexIcons[i].setBackgroundDrawable(getResources().getDrawable(
						R.drawable.focusimg_select_focus));
			else
				indexIcons[i].setBackgroundDrawable(getResources().getDrawable(
						R.drawable.focusimg_select_default));
			focusimg_indexLayout.addView(indexIcons[i]);
		}
	}

	public FocusImgGallery getFocusImgGallery() {
		return mFocusImgGallery;
	}

	public void setFocusImgGallery(FocusImgGallery mFocusImgGallery) {
		this.mFocusImgGallery = mFocusImgGallery;
	}

	public TextView getFocusimg_title() {
		return focusimg_title;
	}

	public void setFocusimg_title(TextView focusimg_title) {
		this.focusimg_title = focusimg_title;
	}

}
