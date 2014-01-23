/** 
 * @author lilin
 * @date 2012-12-28 下午12:27:04 
 * @annotation
 */
package com.dream.myqiyi.ui.tab1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.myqiyi.R;

/**
 * @author lilin
 * @date 2012-12-28 下午12:27:04
 * @annotation
 */
public class ExpandableListAdp extends BaseExpandableListAdapter {
	String[] expandgroups;
	String[][] expandchilds;

	Context context;

	public ExpandableListAdp(Context con, String[] expandgroups,
			String[][] expandchilds) {
		this.expandgroups = expandgroups;
		this.expandchilds = expandchilds;
		context = con;
		// for (int i = 0; i < 5; i++) {
		// for (int j = 0; j < 3; j++) {
		// expandchilds[i][j] = "child" + i + "_" + j;
		// }
		// }
	}

	@Override
	public String getChild(int arg0, int arg1) {

		return expandchilds[arg0][arg1];
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		return 0;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		Log.i("andli", "孩子下标=" + arg0 + "" + arg1);
		ChildHolder mChildHolder;
		if (arg3 == null) {
			arg3 = LayoutInflater.from(context).inflate(
					R.layout.expandablelist_child_item, null);
			mChildHolder = new ChildHolder();
			mChildHolder.playButton = (ImageView) arg3
					.findViewById(R.id.playbtn);
			mChildHolder.playButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(context, "PlayButton Click",
							Toast.LENGTH_LONG).show();
				}
			});

			arg3.setTag(mChildHolder);
		}

		return arg3;
	}

	@Override
	public int getChildrenCount(int arg0) {
		return 3;
	}

	@Override
	public Object getGroup(int arg0) {
		return expandgroups[arg0];
	}

	@Override
	public int getGroupCount() {
		return expandgroups.length;
	}

	@Override
	public long getGroupId(int arg0) {
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		GroupHolder groupHolder;
		if (arg2 == null) {
			arg2 = LayoutInflater.from(context).inflate(
					R.layout.expandablelist_group_item, null);
			groupHolder = new GroupHolder();
			groupHolder.img = (ImageView) arg2.findViewById(R.id.tag_img);
			groupHolder.title = (TextView) arg2.findViewById(R.id.title_view);
			arg2.setTag(groupHolder);
		} else {
			groupHolder = (GroupHolder) arg2.getTag();
		}
		if (HomeView.expandstatus[arg0] == 0) {
			groupHolder.img
					.setImageResource(R.drawable.expandablelist_indecator_button);
		} else {
			groupHolder.img
					.setImageResource(R.drawable.expandablelist_indecator_button_down);
		}
		groupHolder.title.setText(expandgroups[arg0]);

		return arg2;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return true;
	}

	// 父
	class GroupHolder {
		ImageView img;
		TextView title;
	}

	// 子
	class ChildHolder {
		ImageView playButton;
		TextView title;
	}

}
