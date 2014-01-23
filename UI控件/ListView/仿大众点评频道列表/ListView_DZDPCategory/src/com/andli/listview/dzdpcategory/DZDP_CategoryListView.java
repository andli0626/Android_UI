package com.andli.listview.dzdpcategory;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * 
 * @author lilin
 * @date 2012-12-6 下午5:18:53
 * @annotation 类别（频道）界面
 */
public class DZDP_CategoryListView extends Activity {

	View mView;
	LayoutInflater mLayoutInflater;
	ListView mListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// 初始化UI
		mView = this.getLayoutInflater().inflate(
				R.layout.dzdp_categorylistview, null);
		setContentView(mView);

		mListView = (ListView) findViewById(R.id.categorylist);

		// ListView 添加头部UI
		mLayoutInflater = LayoutInflater.from(this);
		LinearLayout listViewHeadView = (LinearLayout) mLayoutInflater.inflate(
				R.layout.listview_headview, null);
		mListView.addHeaderView(listViewHeadView);

		DZDP_CategoryAdp adp = new DZDP_CategoryAdp(this,
				DZDP_CategoryTestData.getData());
		mListView.setAdapter(adp);

	}

}