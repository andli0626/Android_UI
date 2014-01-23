package com.lilin.flipper;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.droidful.flinggallery.R;

public class MainView extends Activity {
	private LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.MATCH_PARENT,
			LinearLayout.LayoutParams.MATCH_PARENT);
	// 控制视图的个数
	public static String[] items = { "CGT主界面", "OA主界面" };
	private FlingGallery flingGallery;
	LinearLayout lineLayout;

	public boolean onTouchEvent(MotionEvent event) {
		return flingGallery.onGalleryTouchEvent(event);
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTitleColor(Color.YELLOW);

		initUI();
		flingGallery = new FlingGallery(this);
		// 设置内边距
		flingGallery.setPaddingWidth(3);
		// 初始化Adp
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 0, items) {
			public View getView(int pos, View convertView, ViewGroup parent) {
				GalleryItem view = new GalleryItem(MainView.this, pos,
						flingGallery);
				setTitle(items[pos]);
				return view;
			}
		};
		flingGallery.setAdapter(adapter);

		lineLayout.addView(flingGallery, layoutParams);
		setIsCircule();
	}

	public void setIsCircule() {
		boolean isCircle = PreferenceManager.getDefaultSharedPreferences(
				MainView.this).getBoolean("fling", true);
		flingGallery.setIsGalleryCircular(isCircle);
	}

	private void initUI() {
		lineLayout = (LinearLayout) findViewById(R.id.lineLayout);
	}

	// 菜单-----------------------------------------------------------

	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 0, "设置").setIcon(android.R.drawable.ic_menu_preferences);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// 设置
		case 1:
			SetView.launch(this);
			break;

		default:

		}
		return super.onOptionsItemSelected(item);
	}

	// 销毁
	protected void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}

	// 暂停
	protected void onPause() {
		setIsCircule();
		System.out.println("onPause");
		super.onPause();
	}

	// 重新启动
	protected void onRestart() {
		System.out.println("onRestart");
		super.onRestart();
	}

	// Resume
	protected void onResume() {
		setIsCircule();
		System.out.println("onResume");
		super.onResume();
	}
}
