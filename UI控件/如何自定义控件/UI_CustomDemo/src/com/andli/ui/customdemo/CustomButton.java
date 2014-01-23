package com.andli.ui.customdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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

	public CustomButton(Context context) {
		super(context);
	}

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.custombuttomview, this);
		imageView = (ImageView) findViewById(R.id.imageView1);
		textView = (TextView) findViewById(R.id.textView1);
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

}
