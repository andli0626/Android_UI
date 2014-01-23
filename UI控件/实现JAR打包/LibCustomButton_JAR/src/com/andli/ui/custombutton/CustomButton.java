package com.andli.ui.custombutton;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author lilin
 * @date 2012-12-14 下午8:33:56
 * @annotation 自定义一个按钮控件：继承LinearLayout
 */
@SuppressLint("ShowToast")
public class CustomButton extends LinearLayout {

	private ImageView imageView;
	private TextView textView;
	private LinearLayout buttonLayout;
	private Context con;

	public CustomButton(Context context) {
		super(context);
		con = context;
	}

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		con = context;

		buttonLayout = new LinearLayout(context);
		buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
		LayoutParams FWParams = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		LayoutParams WWParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		buttonLayout.setLayoutParams(FWParams);
		buttonLayout.setGravity(Gravity.CENTER);

		imageView = new ImageView(context);
		textView = new TextView(context);

		buttonLayout.addView(imageView, WWParams);
		buttonLayout.addView(textView, WWParams);

		this.addView(buttonLayout);

		defaultSettings();
	}

	// 默认设置
	public void defaultSettings() {
		try {
			Bitmap bitmap = BitmapFactory.decodeStream(con.getAssets().open(
					"custombutton_defaultimg.png"));

			Drawable img = new BitmapDrawable(bitmap);
			imageView.setImageDrawable(img);

			textView.setTextColor(Color.RED);
			textView.setTextSize(18);
			textView.setText("确定");

			// 通过代码来实现selecter
			// Drawable normalImg = getImg("custombutton_default_normal.png");
			// Drawable pressImg = getImg("custombutton_default_press.png");
			// final Drawable layoutpressImg =
			// getImg("buttonlayout_default_press.png");
			// final Drawable layoutnormalImg =
			// getImg("buttonlayout_default_normal.png");
			// this.setBackgroundDrawable(layoutnormalImg);
			// this.setOnClickListener(new OnClickListener() {
			//
			// @Override
			// public void onClick(View v) {
			// this.setBackgroundDrawable(layoutpressImg);
			// }
			// });
			// buttonLayout.setClickable(true);
			// buttonLayout.setOnTouchListener(new OnTouchListener() {
			// public boolean onTouch(View v, MotionEvent event) {
			// if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// buttonLayout.setBackgroundDrawable(layoutpressImg);
			// } else if (event.getAction() == MotionEvent.ACTION_UP) {
			// buttonLayout.setBackgroundDrawable(layoutnormalImg);
			// }
			// return false;
			// }
			// });

			// buttonLayout.setMinimumWidth(BitmapFactory.decodeStream(
			// con.getAssets().open("buttonlayout_default_press.png"))
			// .getWidth());
			// buttonLayout.setMinimumHeight(BitmapFactory.decodeStream(
			// con.getAssets().open("buttonlayout_default_press.png"))
			// .getHeight());

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public StateListDrawable setSelect(Drawable normalImg, Drawable pressImg) {
		StateListDrawable selector = new StateListDrawable();
		selector.addState(View.PRESSED_ENABLED_STATE_SET, pressImg);
		selector.addState(View.ENABLED_FOCUSED_STATE_SET, normalImg);
		selector.addState(View.ENABLED_STATE_SET, normalImg);
		selector.addState(View.FOCUSED_STATE_SET, normalImg);
		selector.addState(View.EMPTY_STATE_SET, normalImg);
		return selector;
	}

	public StateListDrawable setLayoutSelect(Drawable normalImg,
			Drawable pressImg) {
		StateListDrawable selector = new StateListDrawable();
		selector.addState(View.PRESSED_ENABLED_STATE_SET, pressImg);
		selector.addState(View.ENABLED_FOCUSED_STATE_SET, pressImg);
		selector.addState(View.ENABLED_STATE_SET, normalImg);
		selector.addState(View.FOCUSED_STATE_SET, pressImg);
		selector.addState(View.EMPTY_STATE_SET, pressImg);// 不可用
		return selector;
	}

	public Drawable getImg(String filename) {

		try {
			return new BitmapDrawable(BitmapFactory.decodeStream(con
					.getAssets().open(filename)));
		} catch (IOException e) {
			Toast.makeText(con, "设置自定义按钮默认图片报错：" + e.toString(),
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		return null;
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
