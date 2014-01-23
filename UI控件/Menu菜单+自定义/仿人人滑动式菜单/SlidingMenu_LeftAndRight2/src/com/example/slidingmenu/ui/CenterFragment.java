package com.example.slidingmenu.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slidingmenu.R;
import com.example.slidingmenu.lib.SlidingView;
import com.example.slidingmenu.lib.SlidingView.OnScrollCloseListener;
import com.example.slidingmenu.lib.SlidingView.OnScrollOpenListener;

public class CenterFragment extends ListFragment implements
		OnScrollOpenListener, OnScrollCloseListener {
	Button showLeft;
	Button showRight;
	private Button station_m;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.centerview, null);
		showLeft = (Button) mView.findViewById(R.id.showLeft);
		showRight = (Button) mView.findViewById(R.id.showRight);
		station_m = (Button) mView.findViewById(R.id.station_m);
		return mView;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		for (int i = 0; i < 20; i++) {
			adapter.add(new SampleItem("Sample List",
					android.R.drawable.btn_star));
		}
		setListAdapter(adapter);

		// 设置页面滑动监听
		((MainView) getActivity()).setOnScrollOpenListener(this);
		((MainView) getActivity()).setOnScrollCloseListener(this);
		// 显示左边页面
		showLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((MainView) getActivity()).showLeft();
				station_m.setVisibility(View.VISIBLE);
			}
		});
		// 显示右边页面
		showRight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((MainView) getActivity()).showRight();
				station_m.setVisibility(View.VISIBLE);
			}
		});
		// 显示中间页面
		station_m.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((MainView) getActivity()).showCenter();
			}
		});
	}

	private class SampleItem {
		public String tag;
		public int iconRes;

		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(
						R.layout.center_listview_listitem, null);
			}
			ImageView icon = (ImageView) convertView
					.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView
					.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}

	// 侧边页面打开监听 回调方法
	@Override
	public void onScrollOpen(SlidingView slidingView) {
		station_m.setVisibility(View.VISIBLE);
	}

	// 侧边页面关闭监听 回调方法
	@Override
	public void onScrollClose(SlidingView slidingView) {
		station_m.setVisibility(View.GONE);
	}
}
