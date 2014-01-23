package com.demo.zsw;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
/**
 * 
 * @author zhoushaowen 
 * @Email  zhoushaowenwork@163.com
 * @QQ     546427660
 * @ps     还有很多细节地方没有完善，如果有兴趣，可以一起研究 分享。
 */
public class Mofang360UIActivity extends Activity {
	public static final String TAG = null;
	/** Called when the activity is first created. */
	private ScrollLayout scrollLayout;
	private ViewPager viewpage;
	private LayoutInflater mInflater;
	private ArrayList<View> views;
	private ImageView iv, message, main_mask_bg;
	private RelativeLayout rl1, rl2;
	private MyOnClickListener myOnClickListener;
	private boolean isOpen = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen_layout);
		initView();
	}

	private void initView() {
		mInflater = LayoutInflater.from(this);
		views = new ArrayList<View>();
		myOnClickListener = new MyOnClickListener();
		
		viewpage = (ViewPager) findViewById(R.id.pager);
		//自定义控件
		scrollLayout = (ScrollLayout) findViewById(R.id.scrollLayout);
        //准备viewpage 的view数据
		View view1 = mInflater.inflate(R.layout.item_page, null);
		View view2 = mInflater.inflate(R.layout.item_page, null);
		rl2 = (RelativeLayout) view1.findViewById(R.id.rl_2);
		rl1 = (RelativeLayout) view1.findViewById(R.id.rl_1);
		rl1.setOnClickListener(myOnClickListener);
		rl2.setOnClickListener(myOnClickListener);
		views.add(view1);
		views.add(view2);

		main_mask_bg = (ImageView) findViewById(R.id.main_menu);
		main_mask_bg.setOnClickListener(myOnClickListener);
		viewpage.setAdapter(new ViewPageAdapter());
	}


	public class MyOnClickListener implements OnClickListener {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.rl_1:
				Toast.makeText(Mofang360UIActivity.this, "DemoActivity rl_1",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.rl_2:
				Toast.makeText(Mofang360UIActivity.this, "DemoActivity rl_2",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.main_menu:
				Log.i(TAG, "main_menu");
				//这里主要是为了适配一些屏幕不同的分辨率
				DisplayMetrics metrics = new DisplayMetrics();
				Mofang360UIActivity.this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
				int width = metrics.widthPixels;
				Log.i(TAG, "width=" + width);
				scrollLayout.scrollToRigth(width);
				break;
			default:
				break;
			}
		}
	}
	public class ViewPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {

			return views.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {

			((ViewPager) arg0).removeView(views.get(arg1));
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(views.get(position));
			return views.get(position);
		}
	}
}