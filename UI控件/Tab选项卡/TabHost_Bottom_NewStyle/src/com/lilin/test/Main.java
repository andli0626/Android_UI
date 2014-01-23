package com.lilin.test;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 主窗体
 * 
 * @author lilin
 * @date 2011-11-5 上午09:32:41
 * @ClassName: Main
 */
public class Main extends TabActivity {
	private RadioGroup radioGroup;
	private TabHost tabHost;
	public static final String TAB1 = "主页";
	public static final String TAB2 = "私信";
	public static final String TAB3 = "评论";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		radioGroup = (RadioGroup) findViewById(R.id.main_radio);

		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec(TAB1).setIndicator(TAB1).setContent(
				new Intent(this, Tab1.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB2).setIndicator(TAB2).setContent(
				new Intent(this, Tab2.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB3).setIndicator(TAB3).setContent(
				new Intent(this, Tab3.class)));

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radio_button0:
					tabHost.setCurrentTabByTag(TAB1);
					break;
				case R.id.radio_button1:
					tabHost.setCurrentTabByTag(TAB2);
					break;
				case R.id.radio_button2:
					tabHost.setCurrentTabByTag(TAB3);
					break;
				default:
					break;
				}
			}
		});
	}
}
