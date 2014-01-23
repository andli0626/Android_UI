package org.example.tabdemo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;

public class Main extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		setTitle("TabWidget居于底部");
		setTitleColor(Color.YELLOW);

		Resources res = getResources();

		TabHost tabhost = (TabHost) findViewById(R.id.tabhost);
		tabhost.setup();

		TabHost.TabSpec spec = tabhost.newTabSpec("tab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("待办", res.getDrawable(R.drawable.menu_1));
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("tab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("公告", res.getDrawable(R.drawable.menu_2));
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("tab3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("邮件", res.getDrawable(R.drawable.menu_3));
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("tab4");
		spec.setContent(R.id.tab4);
		spec.setIndicator("设置", res.getDrawable(R.drawable.menu_4));
		tabhost.addTab(spec);

		tabhost.setCurrentTab(0);
	}
}