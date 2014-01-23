package com.jefry.gallery;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Gallery;
import android.widget.ImageView;

public class FocusImgAdp extends BaseAdapter{

	List<FocusImgInfo> focusImgInfos = new ArrayList<FocusImgInfo>();
	Context context;

	public FocusImgAdp(Context context, List<FocusImgInfo> focusImgInfos) {
		this.focusImgInfos = focusImgInfos;
		this.context = context;

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
		final FocusImgInfo promotion = focusImgInfos.get(position);
		ImageView mImageView = (ImageView) convertView;
		if (mImageView == null) {
			mImageView = new ImageView(context);
		}
		// 设置边界对齐
		mImageView.setAdjustViewBounds(true);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		mImageView.setLayoutParams(new Gallery.LayoutParams(params));
		// 设置比例类型
		mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
		mImageView.setImageBitmap(promotion.getBitmap());
		return mImageView;
	}

}
