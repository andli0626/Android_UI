package com.andli.ui.focusimg;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author lilin
 * @date 2012-12-14 上午11:12:50
 * @annotation 焦点图控件：自定义
 */
public class FocusImgView extends FrameLayout {
	List<FocusImgInfo> focusImgInfos = new ArrayList<FocusImgInfo>();
	private static final double GALLERY_IMAGE_HORIZONTAL_RATIO = 1.0;
	private static final double GALLERY_IMAGE_VERTICAL_RATIO = 1.0;
	private static final int GALLERY_SPACING = 2;

	private Context mContext;
	private FocusImgGallery mFocusImgGallery;
	private LinearLayout focusimg_indexLayout;
	private TextView focusimg_title;
	private int allNums;
	private ImageView[] indexIcons;// 下标

	public FocusImgView(Context context) {
		super(context);
	}

	public FocusImgView(Context context, AttributeSet attrs) {
		super(context, attrs);

		mContext = context;

		// 初始化数据
		Resources res = getResources();

		int imgs[] = { R.drawable.t1, R.drawable.t2, R.drawable.t3 };
		String titles[] = { "标题1", "标题2", "标题3" };

		for (int i = 0; i < imgs.length; i++) {
			Bitmap bmp = BitmapFactory.decodeResource(res, imgs[i]);
			FocusImgInfo mFocusImgInfo = new FocusImgInfo();
			mFocusImgInfo.setBitmap(bmp);
			mFocusImgInfo.setText(titles[i]);
			focusImgInfos.add(mFocusImgInfo);
		}

		// Gallery
		mFocusImgGallery = new FocusImgGallery(context);
		LayoutParams layoutParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.FILL_PARENT,
				android.view.ViewGroup.LayoutParams.FILL_PARENT);
		layoutParams.bottomMargin = 20;
		this.addView(mFocusImgGallery, layoutParams);

		// 底部View
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		View indicator = inflater.inflate(R.layout.focusimg_bottombar, null);
		this.addView(indicator);

		focusimg_indexLayout = (LinearLayout) indicator
				.findViewById(R.id.focusimg_bottombar_index_layout);
		focusimg_title = (TextView) indicator
				.findViewById(R.id.focusimg_bottombar_title);

		initBottomindexIcons();
	}

	/**
	 * 
	 * @author lilin
	 * @date 2012-12-14 下午12:48:58
	 * @annotation 自定义Gallery
	 */
	class FocusImgGallery extends Gallery {

		FocusImgAdp focusImgAdp;

		public FocusImgGallery(Context context) {
			super(context);

			this.setSpacing(GALLERY_SPACING);// 设置间距

			focusImgAdp = new FocusImgAdp(context);
			this.setAdapter(focusImgAdp);
			this.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					update(position);
				}

				public void onNothingSelected(AdapterView<?> parent) {

				}
			});
		}

		// 更新下标Index
		private final void update(int selected) {
			focusimg_title.setText(focusImgInfos.get(selected).getText());
			for (int i = 0; i < allNums; i++) {
				if (selected == i) {
					indexIcons[i].setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.focusimg_select_focus));
				} else {
					indexIcons[i].setBackgroundDrawable(getResources()
							.getDrawable(R.drawable.focusimg_select_default));
				}
			}
		}
	}

	private final void initBottomindexIcons() {
		allNums = focusImgInfos.size();

		indexIcons = new ImageView[allNums];
		focusimg_indexLayout.removeAllViews();
		focusimg_indexLayout.setWeightSum(allNums);

		for (int i = 0; i < allNums; i++) {
			indexIcons[i] = new ImageView(mContext);
			if (i == 0)
				indexIcons[i].setBackgroundDrawable(getResources().getDrawable(
						R.drawable.focusimg_select_focus));
			else
				indexIcons[i].setBackgroundDrawable(getResources().getDrawable(
						R.drawable.focusimg_select_default));
			focusimg_indexLayout.addView(indexIcons[i]);
		}
	}

	/**
	 * 
	 * @author lilin
	 * @date 2012-12-14 上午10:42:42
	 * @annotation 焦点图适配器
	 */
	private final class FocusImgAdp extends BaseAdapter {

		public FocusImgAdp(Context context) {

		}

		public int getCount() {
			return focusImgInfos.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, final View convertView,
				ViewGroup parent) {
			final FocusImgInfo focusImgInfo = focusImgInfos.get(position);
			ImageView mImageView = (ImageView) convertView;
			if (mImageView == null) {
				mImageView = new ImageView(mContext);
			}
			int width = (int) (FocusImgView.this.getWidth() * GALLERY_IMAGE_HORIZONTAL_RATIO);
			int height = (int) (FocusImgView.this.getHeight() * GALLERY_IMAGE_VERTICAL_RATIO);
			mImageView.setLayoutParams(new Gallery.LayoutParams(width, height));
			mImageView.setScaleType(ImageView.ScaleType.CENTER);
			mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
			mImageView.setImageBitmap(focusImgInfo.getBitmap());
			return mImageView;
		}
	}
}
