package com.zxg;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class MyOnTabChangeListener implements OnTabChangeListener {

	MainActivity mainActivity = null;

	public MyOnTabChangeListener(MainActivity activity) {
		mainActivity = activity;
	}

	public void onTabChanged(String arg0) {

		// ***设置当前选中的Tab的背景图
		TextView curTextView = (TextView) mainActivity.tabHost
				.getCurrentTabView().findViewById(R.string.tab_tv_id);
		if ("tab_news".equals(arg0)) {
			this.mainActivity.curTabViewIndex = 0;
			curTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.current_news_tab));
		} else if ("tab_topic".equals(arg0)) {
			this.mainActivity.curTabViewIndex = 1;
			curTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.current_topic_tab));
		} else if ("tab_photo".equals(arg0)) {
			this.mainActivity.curTabViewIndex = 2;
			curTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.current_picture_tab));
		} else if ("tab_comment".equals(arg0)) {
			this.mainActivity.curTabViewIndex = 3;
			curTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.current_comment_tab));
		} else if ("tab_vote".equals(arg0)) {
			this.mainActivity.curTabViewIndex = 4;
			curTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.current_vote_tab));
		}

		// ****还原前一个Tab的背景图
		TextView oldTextView = (TextView) mainActivity.tabHost.getTabWidget()
				.getChildTabViewAt(mainActivity.oldTabViewIndex)
				.findViewById(R.string.tab_tv_id);
		switch (mainActivity.oldTabViewIndex) {
		case 0:
			oldTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.back_news_tab));
			break;
		case 1:
			oldTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.back_topic_tab));
			break;
		case 2:
			oldTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.back_picture_tab));
			break;
		case 3:
			oldTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.back_comment_tab));
			break;
		case 4:
			oldTextView.setBackgroundDrawable(mainActivity.getResources()
					.getDrawable(R.drawable.back_vote_tab));
			break;
		}

		// 计算播放动画
		float fromXDelta = 96;

		TranslateAnimation translateAnimation = null;
		if (this.mainActivity.oldTabViewIndex < this.mainActivity.curTabViewIndex) {
			fromXDelta = 96 * (this.mainActivity.curTabViewIndex - this.mainActivity.oldTabViewIndex);
			translateAnimation = new TranslateAnimation(0, fromXDelta, 0.0F,
					0.0F);
		} else {
			translateAnimation = new TranslateAnimation(0, fromXDelta * -1,
					0.0F, 0.0F);
		}
		translateAnimation.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation arg0) {
			}

			public void onAnimationRepeat(Animation arg0) {
			}

			public void onAnimationEnd(Animation arg0) {

				RelativeLayout.LayoutParams aLayoutParams = (RelativeLayout.LayoutParams) mainActivity.tab_front_bg
						.getLayoutParams();
				aLayoutParams.setMargins(mainActivity.curTabViewIndex * 96, 0,
						0, 0);
				mainActivity.tab_front_bg.setLayoutParams(aLayoutParams);
			}
		});
		translateAnimation.setDuration(200);
		mainActivity.tab_front_bg.startAnimation(translateAnimation);
		this.mainActivity.oldTabViewIndex = mainActivity.curTabViewIndex;
	}
}
