package net.fiex.list;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class FlexListAdapter extends BaseAdapter {
	private Context context;
	private int count;
	private List<Map<String, String>> contentList;

	public FlexListAdapter(Context context,
			List<Map<String, String>> contentList) {
		count = contentList.size();
		this.context = context;
	}

	public int getCount() {
		return count;
	}

	public Object getItem(int pos) {
		return pos;
	}

	public long getItemId(int pos) {
		return pos;
	}

	public View getView(int pos, View v, ViewGroup p) {
		FlexLinearLayout view = null;
		if (null == v) {
			view = new FlexLinearLayout(context, contentList.get(pos), pos,
					false,contentList);
		} else {
			view = (FlexLinearLayout) v;
//			view.setWorkTitleLayout(contentList.get(pos), pos,
//					ListFlexView.isCurItem[pos]);
		}
		return view;
	}
}
