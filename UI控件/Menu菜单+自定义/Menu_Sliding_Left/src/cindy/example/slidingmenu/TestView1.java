package cindy.example.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.andli.widget.SlidingMenuView;

public class TestView1 extends Activity implements OnClickListener {

	Button backbtn;
	Button showLeftMenuButton;
	SlidingMenuView mSlidingMenu;
	TextView msg_txt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_activity_1);

		Intent intent = getIntent();
		String msg = intent.getStringExtra("msg");
		msg_txt = (TextView) findViewById(R.id.msg_txt);
		msg_txt.setText(msg);

		showLeftMenuButton = (Button) findViewById(R.id.showleftmenu);
		backbtn = (Button) findViewById(R.id.backbtn);

		showLeftMenuButton.setOnClickListener(this);
		backbtn.setOnClickListener(this);

		mSlidingMenu = SlidingView.slidingMenuView;

	}

	@Override
	public void onClick(View v) {
		if (v == showLeftMenuButton) {
			mSlidingMenu.snapToScreen(0);
		} else if (v == backbtn) {
			finish();
		}

	}
}
