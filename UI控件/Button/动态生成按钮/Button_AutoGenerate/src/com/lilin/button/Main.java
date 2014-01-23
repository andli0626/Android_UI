package com.lilin.button;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/***
 * 按钮的动态生成
 * 
 * @author lilin
 * @date 2013-9-16 下午3:56:40
 * @annotation
 */
public class Main extends Activity {

	LinearLayout mainlayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		mainlayout = (LinearLayout) findViewById(R.id.mainlayout);
		LinearLayout buttonlayout = new LinearLayout(this);
		buttonlayout.setOrientation(LinearLayout.HORIZONTAL);
		buttonlayout.setGravity(Gravity.CENTER);
		int realcount = 22;
		int count = 0;
		count = realcount;
		if (realcount % 3 == 1) {
			count = realcount + 2;
		}
		if (realcount % 3 == 2) {
			count = realcount + 1;
		}
		for (int i = 1; i <= count; i++) {

			Button button = new Button(this);
			button.setId(i);
			// button.setText("测试" + i);
			button.setText("测试按钮");
			button.setTextSize(18);
			button.setOnClickListener(new LisnerButton());
			if (i > realcount) {
				button.setVisibility(View.INVISIBLE);
			}
			buttonlayout.addView(button, new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			Log.i("andli", i + "---" + i % 3 + "");
			if (i % 3 == 0 || (count == i && count % 3 != 0)) {
				mainlayout.addView(buttonlayout);
				buttonlayout = new LinearLayout(this);
				buttonlayout.setOrientation(LinearLayout.HORIZONTAL);
				buttonlayout.setGravity(Gravity.CENTER);
			}

		}

	}

}

class LisnerButton implements OnClickListener {
	@Override
	public void onClick(View v) {

		int id = v.getId();
		System.out.println("click" + id);
		switch (id) {
		case 0:
			break;
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		default:
			break;
		}
	}
}
