package com.andli.uitest;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager.LayoutParams;

/**
 * 用户信息对话框控件
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-7-2
 */
public class UserInfoDialog extends Dialog {
	
	private LayoutParams layoutParam;

	public UserInfoDialog(Context context) {
		super(context, R.style.Dialog);		
		setContentView(R.layout.user_center_content);
		
		// 设置点击对话框之外能消失
		setCanceledOnTouchOutside(true);
		// 设置window属性
		layoutParam = getWindow().getAttributes();
		layoutParam.gravity = Gravity.TOP;
		layoutParam.dimAmount = 0; // 去背景遮盖
		layoutParam.alpha = 1.0f;
		layoutParam.y = 55;
		getWindow().setAttributes(layoutParam);

	}
}
