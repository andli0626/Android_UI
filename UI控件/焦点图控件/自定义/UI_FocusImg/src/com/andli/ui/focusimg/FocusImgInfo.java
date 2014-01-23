package com.andli.ui.focusimg;

import android.graphics.Bitmap;

public class FocusImgInfo {
	private String text;// 标题
	private Bitmap bitmap;// 图片

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

}
