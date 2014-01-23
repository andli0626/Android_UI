package com.slidingmenu.example.responsiveui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.slidingmenu.example.R;

/**
 * 
 * @author lilin
 * @date 2013-2-1 下午11:58:53
 * @annotation 鸟类菜单列表
 */
public class BirdListViewFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.bird_listview, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		String[] birds = getResources().getStringArray(R.array.birds);

		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1,
				android.R.id.text1, birds);

		setListAdapter(colorAdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		// List项点击事件
		Fragment contentFragment = new BirdGridViewFragment(position);
		if (contentFragment != null) {

			if (getActivity() == null)
				return;

			if (getActivity() instanceof ResponsiveUIView) {
				ResponsiveUIView mResponsiveUIView = (ResponsiveUIView) getActivity();
				mResponsiveUIView.switchContent(contentFragment);
			}

		}
		// switchFragment(contentFragment);
	}

	// private void switchFragment(Fragment fragment) {
	// if (getActivity() == null)
	// return;
	//
	// if (getActivity() instanceof ResponsiveUIView) {
	// ResponsiveUIView ra = (ResponsiveUIView) getActivity();
	// ra.switchContent(fragment);
	// }
	// }
}
