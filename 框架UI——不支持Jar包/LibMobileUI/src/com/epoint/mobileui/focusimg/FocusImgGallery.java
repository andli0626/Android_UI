package com.epoint.mobileui.focusimg;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;

import com.epoint.android.frameui.R;

public class FocusImgGallery extends Gallery {
	private static final int GALLERY_SPACING = 2;// 图片之间的间隔
	List<FocusImgInfo> focusImgInfos = new ArrayList<FocusImgInfo>();
	FocusImgAdp focusImgAdp;

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// 返回false 解决Gallery拖拽滑动过快
		return false;
	}

	public void setUnselectedAlpha(float unselectedAlpha) {
		unselectedAlpha = 1.0f;
		super.setUnselectedAlpha(unselectedAlpha);
	}

	public FocusImgGallery(Context context, List<FocusImgInfo> focusImgInfos) {
		super(context);
		this.focusImgInfos = focusImgInfos;
		this.setSelection(0);
		this.setSpacing(GALLERY_SPACING);
		focusImgAdp = new FocusImgAdp(context, focusImgInfos);
		this.setAdapter(focusImgAdp);
		this.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				updateIndexIcons(position);
			}

			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

	// 更新下标Index
	private final void updateIndexIcons(int selected) {

		FocusImgView.focusimg_title.setText(focusImgInfos.get(selected)
				.getText());
		for (int i = 0; i < FocusImgView.indexIcons.length; i++) {
			if (selected == i) {
				FocusImgView.indexIcons[i].setBackgroundDrawable(getResources()
						.getDrawable(R.drawable.focusimg_select_focus));
			} else {
				FocusImgView.indexIcons[i].setBackgroundDrawable(getResources()
						.getDrawable(R.drawable.focusimg_select_default));
			}
		}
	}

}
