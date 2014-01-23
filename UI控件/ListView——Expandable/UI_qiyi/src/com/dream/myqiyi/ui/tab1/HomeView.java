package com.dream.myqiyi.ui.tab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Gallery;

import com.dream.myqiyi.R;
import com.dream.myqiyi.ui.tab1.focusimg.Focusimg_BottomIndex;
import com.dream.myqiyi.ui.tab1.focusimg.FocusImgGalleryAdp;

/**
 * 
 * @author lilin
 * @date 2012-12-28 上午11:30:53
 * @annotation 首页
 */
public class HomeView extends Activity {
	// expandablelist
	ExpandableListView mExpandList;
	public static int[] expandstatus = new int[] { 0, 0, 0, 0, 0 };// 记录展开/收起状态

	String[] expandgroups;// 父
	String[][] expandchilds;// 子
	int childNums = 3;// 子数量

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homeview);

		expandgroups = new String[] { "同步剧场", "奇艺出品", "热播电影", "3月片花速递", "动漫乐园" };
		expandchilds = new String[expandgroups.length][childNums];

		initFocusImg();
		initExpandList();
	}

	private void initExpandList() {

		mExpandList = (ExpandableListView) findViewById(R.id.expandableListView1);

		ExpandableListAdp adp = new ExpandableListAdp(this, expandgroups,
				expandchilds);

		// mExpandList.addHeaderView(focusImgView);// 添加头部View：焦点图控件

		mExpandList.setAdapter(adp);
		// 展开
		mExpandList.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int arg0) {
				expandstatus[arg0] = 1;
			}
		});
		// 收起
		mExpandList.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int arg0) {
				expandstatus[arg0] = 0;
			}
		});

		mExpandList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(HomeView.this, arg2 + "Click", Toast.LENGTH_LONG)
						.show();

			}
		});

		mExpandList.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(HomeView.this, arg2 + "", Toast.LENGTH_LONG)
						.show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	View focusImgView;
	Focusimg_BottomIndex mMyView;

	private void initFocusImg() {
		// 焦点图控件
		focusImgView = LayoutInflater.from(this).inflate(R.layout.focusimgview,
				null);
		Gallery mGallery = (Gallery) focusImgView
				.findViewById(R.id.home_gallery);
		mMyView = (Focusimg_BottomIndex) focusImgView.findViewById(R.id.myView);
		FocusImgGalleryAdp mGalleryAdapter = new FocusImgGalleryAdp(this);
		mMyView.setCount(mGalleryAdapter.getCount());
		mGallery.setAdapter(mGalleryAdapter);
		mGallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				mMyView.setSeletion(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

	}

}
