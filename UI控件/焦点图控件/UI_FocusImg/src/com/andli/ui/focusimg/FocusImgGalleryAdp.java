package com.andli.ui.focusimg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * 
 * @author lilin
 * @date 2012-12-14 上午9:39:00
 * @annotation 焦点图控件适配器
 */
public class FocusImgGalleryAdp extends BaseAdapter {
	Context mContext;
	int[] res;

	public FocusImgGalleryAdp(Context cnt, int[] imgs) {
		this.mContext = cnt;
		res = imgs;
	}

	@Override
	public int getCount() {
		return res.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		if (view == null) {
			view = LayoutInflater.from(mContext).inflate(
					R.layout.focusimg_gallery_item, null);
		}
		ImageView img = (ImageView) view.findViewById(R.id.focuspicture);
		img.setImageResource(res[arg0]);

		return view;
	}
}
