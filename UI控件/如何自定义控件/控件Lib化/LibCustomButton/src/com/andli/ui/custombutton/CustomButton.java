package com.andli.ui.custombutton;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
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
	private Context con;

	public CustomButton(Context context) {
		super(context);
		con = context;
	}

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		con = context;
		// LayoutInflater inflater = (LayoutInflater) context
		// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// inflater.inflate(R.layout.custombuttomview, this);
		//
		//
		// imageView = (ImageView) findViewById(R.id.imageView1);
		// textView = (TextView) findViewById(R.id.textView1);

		LinearLayout buttonLayout = new LinearLayout(context);
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
		setDefaultParams();
	}

	public void setDefaultParams() {
		try {
			Bitmap bitmap = BitmapFactory.decodeStream(con.getAssets().open(
					"custombutton_defaultimg.png"));

			Drawable img = new BitmapDrawable(bitmap);
			imageView.setImageDrawable(img);
		} catch (IOException e) {
			Toast.makeText(con, "设置自定义按钮默认图片报错：" + e.toString(),
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}

		textView.setTextColor(Color.BLACK);
		textView.setTextSize(18);
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
