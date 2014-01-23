package com.lilin.tabwidget;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.TabHost.OnTabChangeListener;

/**
 * 主界面
 * 
 * @author lilin
 * @date 2011-9-27 下午04:08:51
 * @ClassName: MainView
 * @Description: TODO
 */
public class MainView extends TabActivity implements OnGestureListener,
		OnTouchListener {

	// 主界面上每一项的名字
	String[] item_name1 = { "公文处理", "办公邮件" };// 单项的名字
	int[] item_images1 = { R.drawable.tab11, R.drawable.tab12 };// 单项的图片

	String[] item_name2 = { "通知公告" };// 单项的名字
	int[] item_images2 = { R.drawable.tab21 };// 单项的图片

	String[] item_name3 = { "通讯录", "日常安排" };// 单项的名字
	int[] item_images3 = { R.drawable.tab31, R.drawable.tab32 };// 单项的图片

	String[] item_name4 = { "系统配置", "数据同步", "程序更新" };// 单项的名字
	int[] item_images4 = { R.drawable.tab41, R.drawable.tab42, R.drawable.tab43 };// 单项的图片

	TabHost tabHost;

	private GridView gv1 = null;
	private GridView gv2 = null;
	private GridView gv3 = null;
	private GridView gv4 = null;

	private ViewFlipper viewFlipper;
	private GestureDetector gestureDetector;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏

		setContentView(R.layout.main);
		setTitle("主界面");
		setTitleColor(Color.YELLOW);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏注意,这个设置必须放在设置布局前面,不然会报错

		init();

		tabHost = getTabHost();

		/* 自定义标签 */
		setIndicator(R.drawable.tab1, "办公", R.id.tab1);
		setIndicator(R.drawable.tab2, "资讯", R.id.tab2);
		setIndicator(R.drawable.tab3, "联系", R.id.tab3);
		setIndicator(R.drawable.tab4, "设置", R.id.tab4);

		tabHost.setCurrentTab(0);// 默认显示tab1

		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			// 选项卡单击事件
			public void onTabChanged(String tabId) {
				Toast.makeText(MainView.this, tabId, Toast.LENGTH_LONG).show();
			}
		});
		gestureDetector = new GestureDetector(this);
		viewFlipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper);

	}

	private void init() {
		gv1 = (GridView) this.findViewById(R.id.gridview1);
		gv2 = (GridView) this.findViewById(R.id.gridview2);
		gv3 = (GridView) this.findViewById(R.id.gridview3);
		gv4 = (GridView) this.findViewById(R.id.gridview4);
		// 设置GridView的相应参数
		SetGridView.setGridView(gv1, 3, 10, 10, 0);
		SetGridView.setGridView(gv2, 3, 10, 10, 0);
		SetGridView.setGridView(gv3, 3, 10, 10, 0);
		SetGridView.setGridView(gv4, 3, 10, 10, 0);

		// 适配器
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, //
				GetDataList.getDataList(item_name1, item_images1), //
				R.layout.mainview_item,//
				new String[] { "images", "name" }, //
				new int[] { R.id.item_image, R.id.item_text });//
		gv1.setAdapter(simpleAdapter);

		simpleAdapter = new SimpleAdapter(this, GetDataList.getDataList(
				item_name2, item_images2), R.layout.mainview_item,
				new String[] { "images", "name" }, new int[] { R.id.item_image,
						R.id.item_text });

		gv2.setAdapter(simpleAdapter);

		simpleAdapter = new SimpleAdapter(this, GetDataList.getDataList(
				item_name3, item_images3), R.layout.mainview_item,
				new String[] { "images", "name" }, new int[] { R.id.item_image,
						R.id.item_text });
		gv3.setAdapter(simpleAdapter);

		simpleAdapter = new SimpleAdapter(this, GetDataList.getDataList(
				item_name4, item_images4), R.layout.mainview_item,
				new String[] { "images", "name" }, new int[] { R.id.item_image,
						R.id.item_text });
		gv4.setAdapter(simpleAdapter);
	}

	// 重写setIndicator方法，实现自定义的XML
	private void setIndicator(int icon, String title, int view) {
		View localView = LayoutInflater.from(tabHost.getContext()).inflate(
				R.layout.tab_view2, null);
		((ImageView) localView.findViewById(R.id.main_activity_tab_image))
				.setBackgroundResource(icon);
		((TextView) localView.findViewById(R.id.main_activity_tab_text))
				.setText(title);
		tabHost.addTab(tabHost.newTabSpec(title).setIndicator(localView)
				.setContent(view));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, Menu.FIRST, 1, "切换视图");
		menu.add(0, Menu.FIRST + 1, 2, "注销登录");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case 1:
			Intent intent = new Intent(MainView.this, MainView2.class);
			startActivity(intent);
			break;
		case 2:
			break;
		}
		return true;
	}

	public boolean onDoubleTap(MotionEvent e) {
		if (viewFlipper.isFlipping()) {
			viewFlipper.stopFlipping();
		} else {
			viewFlipper.startFlipping();
		}
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return this.gestureDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// 滑动手势事件
		if (e1.getX() - e2.getX() > 60) {// 向右滑动，下一页
			// setOutAnimation: 设置View退出屏幕时候使用的动画，参数setInAnimation函数一样。
			this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
					R.anim.zoomin));
			this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
					R.anim.zoomout));
			this.viewFlipper.showNext();// 调用该函数来显示FrameLayout里面的下一个View。
			return true;
		} else if (e1.getX() - e2.getX() < -60) {// 向左滑动，上一页
			this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
					R.anim.zoomin));
			this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
					R.anim.zoomout));
			this.viewFlipper.showPrevious();// 调用该函数来显示FrameLayout里面的上一个View。
			return true;
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
