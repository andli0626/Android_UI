package cindy.example.slidingmenu;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.andli.widget.SlidingMenuView;

public class MainView extends ActivityGroup implements OnClickListener {
	public static SlidingMenuView slidingMenuView;

	ViewGroup slidingBody;

	// 左菜单
	Button left_hide_btn;
	Button left_show_rightmenu_btn;
	Button left_showview1_btn;
	Button left_showview2_btn;

	// 右菜单
	Button right_hideMenu_Btn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);

		slidingMenuView = (SlidingMenuView) findViewById(R.id.sliding_menu_view);

		slidingBody = (ViewGroup) slidingMenuView
				.findViewById(R.id.sliding_body);

		left_hide_btn = (Button) findViewById(R.id.hidemenu_btn);
		left_show_rightmenu_btn = (Button) findViewById(R.id.showRight_btn);
		left_showview1_btn = (Button) findViewById(R.id.showview1_btn);
		left_showview2_btn = (Button) findViewById(R.id.showview2_btn);

		left_hide_btn.setOnClickListener(this);
		left_show_rightmenu_btn.setOnClickListener(this);
		left_showview1_btn.setOnClickListener(this);
		left_showview2_btn.setOnClickListener(this);

		right_hideMenu_Btn = (Button) findViewById(R.id.right_hidemenu_btn);
		right_hideMenu_Btn.setOnClickListener(this);

		setView(TestActivity1.class);
	}

	@Override
	public void onClick(View v) {
		if (v == left_hide_btn) {
			slidingMenuView.snapToScreen(1);
		} else if (v == left_show_rightmenu_btn) {
			slidingMenuView.snapToScreen(2);
		} else if (v == left_showview1_btn) {
			slidingMenuView.snapToScreen(1);
			setView(TestActivity1.class);
		} else if (v == left_showview2_btn) {
			slidingMenuView.snapToScreen(1);
			setView(TestActivity2.class);
		} else if (v == right_hideMenu_Btn) {
			slidingMenuView.snapToScreen(1);
		}
	}

	//
	private void setView(Class<?> c) {
		Intent i = new Intent(this, c);
		View v = getLocalActivityManager().startActivity(TestActivity1.class.getName(), i).getDecorView();
		slidingBody.removeAllViews();
		slidingBody.addView(v);
	}
}
