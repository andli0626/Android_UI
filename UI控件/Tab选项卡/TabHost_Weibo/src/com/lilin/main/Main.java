package com.lilin.main;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class Main extends TabActivity {
	TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tabHost = getTabHost();

		// 快速发布
		Intent publish = new Intent(this, Tab1.class);

		// 好友列表
		Intent friend = new Intent(this, Tab2_3.class);

		// 最近访客
		Intent contacts = new Intent(this, Tab2_3.class);

		// 日志列表
		Intent diary = new Intent(this, Tab4.class);

		// 相册列表
		Intent album = new Intent(this, Tab5.class);

		setIndicator(R.drawable.publish, "快速发布", publish);
		setIndicator(R.drawable.friend, "我的好友", friend);
		setIndicator(R.drawable.visitor, "最近访客", contacts);
		setIndicator(R.drawable.diary, "我的日志", diary);
		setIndicator(R.drawable.album, "我的相册", album);
		tabHost.setCurrentTab(0);// 设置默认显示的标签页

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, "搜索").setIcon(R.drawable.search);
		menu.add(0, 1, 0, "退出").setIcon(R.drawable.exit);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0: // 按下搜索菜单选项

			break;
		case 1: // 按下退出菜单选项
			new AlertDialog.Builder(this).setTitle("提示").setMessage("确认退出吗？")
					.setIcon(R.drawable.alert_icon).setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,int which) {
									android.os.Process.killProcess(android.os.Process.myPid()); // 结束进程
								}
							}).setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,int which) {
								}
							}).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// 重写了setIndicator方法
	private void setIndicator(int icon, String title, Intent publish) {
		View localView = LayoutInflater.from(tabHost.getContext()).inflate(R.layout.tab_view, null);
		((ImageView) localView.findViewById(R.id.main_activity_tab_image)).setBackgroundResource(icon);
		((TextView) localView.findViewById(R.id.main_activity_tab_text)).setText(title);
		tabHost.addTab(tabHost.newTabSpec(title).setIndicator(localView).setContent(publish));
	}
}