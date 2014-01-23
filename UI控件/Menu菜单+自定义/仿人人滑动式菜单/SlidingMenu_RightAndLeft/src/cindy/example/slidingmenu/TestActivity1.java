package cindy.example.slidingmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.andli.widget.SlidingMenuView;

public class TestActivity1 extends Activity implements OnClickListener {

	Button showRightMenuButton;
	Button showLeftMenuButton;
	SlidingMenuView mSlidingMenu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_activity_1);

		showLeftMenuButton = (Button) findViewById(R.id.showleftmenu);
		showRightMenuButton = (Button) findViewById(R.id.showrightmenu);

		showLeftMenuButton.setOnClickListener(this);
		showRightMenuButton.setOnClickListener(this);

		mSlidingMenu = MainView.slidingMenuView;

	}

	@Override
	public void onClick(View v) {
		if (v == showLeftMenuButton) {
			mSlidingMenu.snapToScreen(0);
		} else if (v == showRightMenuButton) {
			mSlidingMenu.snapToScreen(2);
		}

	}
}
