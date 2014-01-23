package com.example.viewpagerindicator_tabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.viewpagerindicator.TabPageIndicator;

public class TabDemo extends FragmentActivity {
	private static final String[] CONTENT = new String[] { "今日要闻", "娱乐播报",
			"体育新闻", "微博互动", "视频新闻" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.simple_tabs);

		FragmentPagerAdapter adapter = new MyPageAdp(
				getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}

	class MyPageAdp extends FragmentPagerAdapter {
		public MyPageAdp(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Log.i("andli", position + "");
			if (position == 0) {
				return TestTabView2.newInstance(CONTENT[position
						% CONTENT.length]);
			} else {
				return TestTabView.newInstance(CONTENT[position
						% CONTENT.length]);
			}

		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length].toUpperCase();
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}
	}
}
