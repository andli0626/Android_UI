package com.and.netease;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

public class SHHP_MainView extends TabActivity implements OnClickListener {
	TabHost tabHost;
	TabHost.TabSpec tabSpec;

	public static String JRHP = "JRHP";
	public static String HPYW = "HPYW";
	public static String CSMP = "CSMP";
	public static String MORE = "MORE";

	Button hpywButton;
	Button jrhpButton;
	Button csmpButton;
	Button moreButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shhp_main);

		initUI();

	}

	private void initUI() {
		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec(HPYW).setIndicator(HPYW)
				.setContent(new Intent(this, SHHP_Tab_HPYWView.class)));

		tabHost.addTab(tabHost.newTabSpec(JRHP).setIndicator(JRHP)
				.setContent(new Intent(this, SHHP_Tab_JRHPView.class)));

		tabHost.addTab(tabHost.newTabSpec(CSMP).setIndicator(CSMP)
				.setContent(new Intent(this, SHHP_Tab_CSMPView.class)));

		tabHost.addTab(tabHost.newTabSpec(MORE).setIndicator(MORE)
				.setContent(new Intent(this, SHHP_Tab_MoreView.class)));

		hpywButton = (Button) findViewById(R.id.bottom_buttom_hpyw);
		jrhpButton = (Button) findViewById(R.id.bottom_buttom_jrhp);
		csmpButton = (Button) findViewById(R.id.bottom_buttom_csmp);
		moreButton = (Button) findViewById(R.id.bottom_buttom_more);

		hpywButton.setOnClickListener(this);
		jrhpButton.setOnClickListener(this);
		csmpButton.setOnClickListener(this);
		moreButton.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v == hpywButton) {
			tabHost.setCurrentTabByTag(HPYW);
		} else if (v == jrhpButton) {
			tabHost.setCurrentTabByTag(JRHP);
		} else if (v == csmpButton) {
			tabHost.setCurrentTabByTag(CSMP);
		} else if (v == moreButton) {
			tabHost.setCurrentTabByTag(MORE);
		}

	}
}