package com.epoint.android.customui.topbar;

import com.epoint.android.customui.help.CustomHelp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 
 * @author lilin
 * @date 2012-12-16 下午7:10:57
 * @annotation 自定义topbar
 */
public class FrameTopBar extends RelativeLayout {

	// 默认配置参数
	int textSize = 15;// 字体大小
	int titletextSize = 23;// 字体大小
	int textColor = Color.WHITE;// 字体颜色

	// 图片名称
	String frame_topbar_bg = "frame_topbar_bg.png";

	String lefttext = "     ";
	String righttext = "菜单";
	String titletext = "顶部动作条";

	Context con;

	Button leftButton;
	Button rightButton;
	TextView toptitle;
	ProgressBar pd;
	RelativeLayout topbarLayout;

	public FrameTopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		con = context;
		initUI();
	}

	public FrameTopBar(Context context) {
		super(context);
		con = context;
		initUI();

	}

	public void initUI() {
		// RelativeLayout parentLayout = new RelativeLayout(con);
		// LayoutParams parentLayoutParams = new LayoutParams(
		// LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);

		topbarLayout = new RelativeLayout(con);

		LayoutParams mParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		mParams.addRule(RelativeLayout.CENTER_VERTICAL);// 设置垂直居中
		mParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		leftButton = new Button(con);
		leftButton.setText(lefttext);
		leftButton.setTextSize(textSize);
		leftButton.setGravity(Gravity.CENTER);
		leftButton.setTextColor(textColor);

		leftButton.setBackgroundDrawable(CustomHelp.newSelector(con,
				"frame_topbar_leftbutton_normal.png",
				"frame_topbar_leftbutton_press.png",
				"frame_topbar_leftbutton_normal.png",
				"frame_topbar_leftbutton_normal.png"));

		topbarLayout.addView(leftButton, mParams);

		mParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		mParams.addRule(RelativeLayout.CENTER_VERTICAL);// 设置垂直居中
		mParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		toptitle = new TextView(con);
		toptitle.setGravity(Gravity.CENTER);
		toptitle.setTextColor(textColor);
		toptitle.setTextSize(titletextSize);
		toptitle.setText(titletext);

		topbarLayout.addView(toptitle, mParams);

		mParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		mParams.addRule(RelativeLayout.CENTER_VERTICAL);// 设置垂直居中
		mParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rightButton = new Button(con);
		rightButton.setGravity(Gravity.CENTER);
		rightButton.setText(righttext);
		rightButton.setTextColor(textColor);
		rightButton.setTextSize(textSize);
		rightButton.setBackgroundDrawable(CustomHelp.newSelector(con,
				"frame_topbar_rightbutton_normal.png",
				"frame_topbar_rightbutton_press.png",
				"frame_topbar_rightbutton_normal.png",
				"frame_topbar_rightbutton_normal.png"));

		topbarLayout.addView(rightButton, mParams);

		mParams = new LayoutParams(25, 25);
		mParams.addRule(RelativeLayout.CENTER_VERTICAL);// 设置垂直居中
		mParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		pd = new ProgressBar(con);
		pd.setVisibility(View.GONE);

		topbarLayout.addView(pd, mParams);

		LayoutParams topbarLayoutParams = new LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		topbarLayout.setBackgroundDrawable(CustomHelp.getImgFromAsserts(con,
				frame_topbar_bg));

		this.addView(topbarLayout, topbarLayoutParams);

	}

	public Button getLeftButton() {
		return leftButton;
	}

	public Button getRightButton() {
		return rightButton;
	}

	public TextView getToptitleTextView() {
		return toptitle;
	}

	public ProgressBar getTopProgressBar() {
		return pd;
	}

	public RelativeLayout getTopBarLayout() {
		return topbarLayout;
	}

}
