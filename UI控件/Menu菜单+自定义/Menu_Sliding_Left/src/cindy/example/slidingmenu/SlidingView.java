package cindy.example.slidingmenu;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.andli.widget.SlidingMenuView;

public class SlidingView extends ActivityGroup implements OnClickListener {
	public static SlidingMenuView slidingMenuView;

	ViewGroup slidingBody;

	// 左菜单
	Button left_hide_btn;
	Button left_showview1_btn;
	Button left_showview2_btn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidingview);

		slidingMenuView = (SlidingMenuView) findViewById(R.id.sliding_menu_view);

		slidingBody = (ViewGroup) slidingMenuView
				.findViewById(R.id.sliding_body);

		left_hide_btn = (Button) findViewById(R.id.hidemenu_btn);
		left_showview1_btn = (Button) findViewById(R.id.showview1_btn);
		left_showview2_btn = (Button) findViewById(R.id.showview2_btn);

		left_hide_btn.setOnClickListener(this);
		left_showview1_btn.setOnClickListener(this);
		left_showview2_btn.setOnClickListener(this);

		setView(TestView1.class, "同一个界面：首页");
	}

	@Override
	public void onClick(View v) {
		if (v == left_hide_btn) {
			slidingMenuView.snapToScreen(1);
		} else if (v == left_showview1_btn) {
			slidingMenuView.snapToScreen(1);
			setView(TestView2.class, "不同的界面");
			setView(TestView1.class, "同一个页面：非首页");
		} else if (v == left_showview2_btn) {
			slidingMenuView.snapToScreen(1);
			setView(TestView2.class, "不同的界面");
		}
	}

	private void setView(Class<?> c, String msg) {
		Intent i = new Intent(this, c);
		i.putExtra("msg", msg);
		View v = getLocalActivityManager().startActivity(
				TestView1.class.getName(), i).getDecorView();
		slidingBody.removeAllViews();
		slidingBody.addView(v);
	}
}
