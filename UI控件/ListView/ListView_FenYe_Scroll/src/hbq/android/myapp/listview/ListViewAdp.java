package hbq.android.myapp.listview;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 要用用于生成显示数据
 * 
 */
class ListViewAdp extends BaseAdapter {
	int count = 10;
	private static final String TAG = "ButtonLoadingActivity";
	Context context;

	public ListViewAdp(Context context) {
		this.context = context;
	}

	public int getCount() {
		Log.i(TAG, "getCount>>>count:" + count);
		return count;
	}

	public Object getItem(int pos) {
		Log.i(TAG, "getItem>>>pos:" + pos);
		return pos;
	}

	public long getItemId(int pos) {
		Log.i(TAG, "getItemId>>>ItemId:" + pos);
		return pos;
	}

	public View getView(int pos, View v, ViewGroup p) {
		Log.i(TAG, "getView>>>pos:" + pos);
		TextView view;
		if (v == null) {
			view = new TextView(context);
		} else {
			view = (TextView) v;
		}
		view.setText("ListItem " + pos);
		view.setTextSize(20f);
		view.setGravity(Gravity.CENTER);
		view.setHeight(60);
		return view;
	}
}
