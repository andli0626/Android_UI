package com.df.UI.category;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.df.UI.DZDP_POIListView;
import com.df.dianping.R;

/**
 * 
 * @author lilin
 * @date 2012-12-6 下午5:18:53
 * @annotation 类别（频道）界面
 */
public class DZDP_CategoryView extends Activity {

	View view;

	// Handler handler = new Handler() {
	// public void handleMessage(Message paramMessage) {
	// if (paramMessage.what == KeyEvent.KEYCODE_BACK) {
	// finish();
	// }
	// }
	// };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		view = this.getLayoutInflater().inflate(R.layout.dzdp_categoryview,
				null);

		setContentView(view);

		LayoutInflater inflater = LayoutInflater.from(this);
		LinearLayout header = (LinearLayout) inflater.inflate(
				R.layout.dzdp_category_headerview, null);

		ListView list = (ListView) findViewById(R.id.categorylist);
		list.addHeaderView(header);
		list.setOnItemClickListener(mOnClickListener);
		ListAdapter adapter = new DZDP_CategoryAdp(this, DZDP_CategoryData.getData());
		list.setAdapter(adapter);

		Animation mAnimationScale = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		mAnimationScale.setDuration(600);
		view.startAnimation(mAnimationScale);

	}

	private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			Intent intent = new Intent(DZDP_CategoryView.this,
					DZDP_POIListView.class);
			startActivity(intent);
		}
	};

	public final class ViewHolder {
		public ImageView img;
		public TextView title;
	}

	// public class MyAdapter extends BaseAdapter {
	//
	// private LayoutInflater mInflater;
	//
	// public MyAdapter(Context context) {
	// this.mInflater = LayoutInflater.from(context);
	// }
	//
	// @Override
	// public int getCount() {
	// // TODO Auto-generated method stub
	// return mData.size();
	// }
	//
	// @Override
	// public Object getItem(int arg0) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public long getItemId(int arg0) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public View getView(int position, View convertView, ViewGroup parent) {
	//
	// ViewHolder holder = null;
	// if (convertView == null) {
	// holder = new ViewHolder();
	//
	// convertView = mInflater.inflate(R.layout.categoryitem, null);
	// convertView.setMinimumHeight(100);
	// holder.img = (ImageView) convertView
	// .findViewById(R.id.category_icon);
	// holder.title = (TextView) convertView
	// .findViewById(R.id.category_name);
	//
	// convertView.setTag(holder);
	//
	// } else {
	//
	// holder = (ViewHolder) convertView.getTag();
	// }
	// holder.img.setBackgroundResource((Integer) mData.get(position).get(
	// "img"));
	// holder.title.setText((String) mData.get(position).get("title"));
	//
	// return convertView;
	// }
	//
	// }

	boolean isBack;

	public void onPause() {
		if (isBack) {
			isBack = false;
			overridePendingTransition(R.anim.back_enter, R.anim.back_exit);
		}
		super.onPause();
	}

	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			isBack = true;
		}

		return super.onKeyUp(keyCode, event);
	}
}