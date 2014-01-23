package com.df.UI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.df.UI.category.DZDP_CategoryView;
import com.df.dianping.R;

/**
 * 
 * @author lilin
 * @date 2012-12-6 下午5:10:00
 * @annotation 主界面
 */
public class DZDP_MainView extends Activity {
	private GridView mGridView;
	private DisplayMetrics localDisplayMetrics;
	private View view;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		view = this.getLayoutInflater().inflate(R.layout.dzdp_main, null);
		setContentView(view);

		localDisplayMetrics = getResources().getDisplayMetrics();

		mGridView = (GridView) view.findViewById(R.id.my_grid);
		ListAdapter adapter = new MainGridAdp(this);
		mGridView.setAdapter(adapter);
		mGridView.setOnItemClickListener(mOnClickListener);
	}

	// 点击事件
	private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			Intent intent = new Intent();
			intent.setClass(DZDP_MainView.this, DZDP_CategoryView.class);
			startActivity(intent);
			// 打开的动画效果
			overridePendingTransition(R.anim.main_enter, R.anim.main_exit);
		}
	};

	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			this.finish();
		}
		return super.onKeyUp(keyCode, event);
	}

	/**
	 * 
	 * @author lilin
	 * @date 2012-12-6 下午5:16:34
	 * @annotation 自定义网格布局适配器
	 */
	public class MainGridAdp extends BaseAdapter {
		private LayoutInflater inflater;

		public MainGridAdp(Context context) {
			inflater = LayoutInflater.from(context);
		}

		public final int getCount() {
			return 9;
		}

		public final Object getItem(int paramInt) {
			return null;
		}

		public final long getItemId(int paramInt) {
			return paramInt;
		}

		public View getView(int paramInt, View paramView,
				ViewGroup paramViewGroup) {
			paramView = inflater.inflate(R.layout.dzdp_main_griditem, null);
			TextView text = (TextView) paramView
					.findViewById(R.id.activity_name);

			switch (paramInt) {
			case 0:
				setGridItem(text, "附件", R.drawable.dzdp_main_fj);
				break;

			case 1:
				setGridItem(text, "搜索", R.drawable.dzdp_main_ss);
				break;

			case 2:
				setGridItem(text, "签到", R.drawable.dzdp_main_qd);
				break;

			case 3:
				setGridItem(text, "优惠券", R.drawable.dzdp_main_yhq);
				break;

			case 4:
				setGridItem(text, "今日团购", R.drawable.dzdp_main_jrtg);
				break;

			case 5:
				setGridItem(text, "排行榜", R.drawable.dzdp_main_phb);
				break;

			case 6:
				setGridItem(text, "最近浏览", R.drawable.dzdp_main_zjll);
				break;
			case 7:
				setGridItem(text, "个人中心", R.drawable.dzdp_main_grzx);
				break;
			case 8:
				setGridItem(text, "更多", R.drawable.dzdp_main_gd);
				break;
			}

			paramView
					.setMinimumHeight((int) (96.0F * localDisplayMetrics.density));
			paramView
					.setMinimumWidth(((-12 + localDisplayMetrics.widthPixels) / 3));

			return paramView;
		}
	}

	// 设置GridView的每一项
	public void setGridItem(TextView textview, String text, int drawid) {
		// TextView插入图片
		textview.setText(text);
		Drawable draw = getResources().getDrawable(drawid);
		int w = draw.getIntrinsicWidth();
		int h = draw.getIntrinsicWidth();
		draw.setBounds(0, 0, w, h);// left, top, right, bottom
		textview.setCompoundDrawables(null, draw, null, null);
	}

}