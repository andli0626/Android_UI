package com.epoint.android.customui.test;

import com.epoint.android.customui.help.CustomHelp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author lilin
 * @date 2012-12-14 下午8:33:56
 * @annotation 自定义一个按钮控件：继承LinearLayout
 */
public class CustomButton extends LinearLayout {

	private ImageView imageView;
	private TextView textView;
	private LinearLayout buttonLayout;
	private Context con;

	public CustomButton(Context context) {
		super(context);
		con = context;
		InitUI();
	}

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		con = context;

		InitUI();
	}

	private void InitUI() {
		buttonLayout = new LinearLayout(con);
		buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
		LayoutParams FWParams = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		LayoutParams WWParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		// LayoutParams imgParams = new LayoutParams(20, 20);
		buttonLayout.setLayoutParams(FWParams);
		buttonLayout.setGravity(Gravity.CENTER);
		// buttonLayout.setHorizontalGravity(Gravity.CENTER);

		imageView = new ImageView(con);
		textView = new TextView(con);

		buttonLayout.addView(imageView, WWParams);
		buttonLayout.addView(textView, WWParams);

		this.addView(buttonLayout);
		this.setClickable(true);// 不可少，否则点击看不到切换效果

		defaultSettings();

	}

	// 默认设置
	public void defaultSettings() {

		imageView.setImageDrawable(CustomHelp.getImgFromAsserts(con,
				"custombutton_defaultimg.png"));
		textView.setTextColor(Color.RED);
		textView.setTextSize(18);
		textView.setText("自定义按钮");

		// 设置selector
		Drawable idNormal = CustomHelp.getImgFromAsserts(con,
				"custombutton_default_normal.png");
		Drawable idPressed = CustomHelp.getImgFromAsserts(con,
				"custombutton_default_press.png");
		Drawable idFocused = CustomHelp.getImgFromAsserts(con,
				"custombutton_default_normal.png");
		Drawable idUnable = CustomHelp.getImgFromAsserts(con,
				"custombutton_default_normal.png");
		this.setBackgroundDrawable(CustomHelp.newSelector(con, idNormal,
				idPressed, idFocused, idUnable));

	}

	/**
	 * 设置图片资源
	 */
	public void setImage(int resId) {
		imageView.setImageResource(resId);
	}

	/**
	 * 设置显示的文字
	 */
	public void setText(String text) {
		textView.setText(text);
	}

	public TextView getTextView() {
		return textView;
	}

	public ImageView getImageView() {
		return imageView;
	}

}
