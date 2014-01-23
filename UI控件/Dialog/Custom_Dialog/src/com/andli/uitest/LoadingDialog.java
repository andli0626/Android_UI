package com.andli.uitest;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

/**
 * 加载对话框控件
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
public class LoadingDialog extends Dialog {

	private Context mContext;
	private LayoutInflater inflater;
	private LayoutParams layoutParam;
	private TextView loadtext;

	public LoadingDialog(Context context) {
		super(context, R.style.Dialog);

		this.mContext = context;

		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflater.inflate(R.layout.loadingdialog, null);
		setContentView(view);

		loadtext = (TextView) view.findViewById(R.id.loading_text);

		// 设置window属性
		layoutParam = getWindow().getAttributes();
		layoutParam.gravity = Gravity.CENTER;
		layoutParam.dimAmount = 0; // 去背景遮盖
		layoutParam.alpha = 1.0f;
		getWindow().setAttributes(layoutParam);

	}

	public void setLoadText(String content) {
		loadtext.setText(content);
	}
}