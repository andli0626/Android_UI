package net.fiex.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

public class ListFlexView extends ListActivity implements OnScrollListener,
		OnItemClickListener {
	private static String LAYOUT_INFLATER_SERVICE = Context.LAYOUT_INFLATER_SERVICE;

	private LayoutInflater mInflater;

	private FlexListAdapter adapter;

	private List<Map<String, String>> contentList;
	private boolean[] isCurItem;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mInflater = (LayoutInflater) this
				.getSystemService(LAYOUT_INFLATER_SERVICE);

		init();
		setListAdapter(adapter);
		getListView().setBackgroundColor(Color.WHITE);
		getListView().setCacheColorHint(Color.TRANSPARENT);
		getListView().setDivider(
				getResources().getDrawable(R.color.transparent));
		getListView().setSelector(R.drawable.work_detail_click_bg);
		getListView().setOnScrollListener(this);
		getListView().setOnItemClickListener(this);
	}

	/**
	 * 初始化数据
	 */
	private void init() {
		contentList = new ArrayList<Map<String, String>>();

		Map<String, String> contentMap = new HashMap<String, String>();
		contentMap.put("title", "我们都是幸运的人");
		contentMap.put("status_img", "true");
		contentMap.put("start_time", "2011-04-11");
		contentMap.put("end_time", "2011-05-21");
		contentMap.put("name", "张北，李西，王东，谭北，居中正");
		contentMap.put("detail", "      在这个世界里，我们都是一群幸运的人，因为上天怜惜，"
				+ "赐与我们一副完整的身体，和健全的头脑，让我们在这世上走一遭，当是幸运无比的人。");
		contentMap.put("headname", "国政");

		Map<String, String> contentMap_1 = new HashMap<String, String>();
		contentMap_1.put("title", "生活的大城市");
		contentMap_1.put("status_img", "false");
		contentMap_1.put("start_time", "2011-03-11");
		contentMap_1.put("end_time", "2011-05-11");
		contentMap_1.put("name", "黑三，王二");
		contentMap_1.put("detail", "      不知道为什么，我在这个城市，"
				+ "找不到任何活着的意义，因为我不明白，我在这里的意义。");
		contentMap_1.put("headname", "张零");

		Map<String, String> contentMap_2 = new HashMap<String, String>();
		contentMap_2.put("title", "向往中的生活");
		contentMap_2.put("status_img", "false");
		contentMap_2.put("start_time", "2010-11-02");
		contentMap_2.put("end_time", "2010-12-01");
		contentMap_2.put("name", "刘王，齐皇，塞帝");
		contentMap_2.put("detail", "      向往着田园的生活，却奋斗在喧嚣的都市。");
		contentMap_2.put("headname", "王皇帝");
		Map<String, String> contentMap_3 = new HashMap<String, String>();
		contentMap_3.put("title", "不知道为什么");
		contentMap_3.put("status_img", "true");
		contentMap_3.put("start_time", "2011-01-21");
		contentMap_3.put("end_time", "2011-06-27");
		contentMap_3.put("name", "毛东");
		contentMap_3.put("detail", "     你说真的可以吗？");
		contentMap_3.put("headname", "未知");

		Map<String, String> contentMap_4 = new HashMap<String, String>();
		contentMap_4.put("title", "世界无限大");
		contentMap_4.put("status_img", "false");
		contentMap_4.put("start_time", "2001-07-11");
		contentMap_4.put("end_time", "2001-05-21");
		contentMap_4.put("name", "中美日");
		contentMap_4.put("detail", "      这个世界真的很大，青山绿水，山川高原，有着无数的地方"
				+ "，等待我们去探索。\r\n这个世界真的很大，琴棋书画，衣食住行，每一样都着独特的魅力"
				+ "，让我们去学习。\r\n这个世界，真的很大。");
		contentMap_4.put("headname", "乡");

		Map<String, String> contentMap_5 = new HashMap<String, String>();
		contentMap_5.put("title", "信念");
		contentMap_5.put("status_img", "true");
		contentMap_5.put("start_time", "2011-04-11");
		contentMap_5.put("end_time", "2011-05-21");
		contentMap_5.put("name", "信念");
		contentMap_5.put("detail", "      当你抱着一个信念，意志坚定的走下去，即便神魔，"
				+ "也不敢说什么，可惜如今太多的人面对残酷的现实，丢失了信仰，如此的你怎么去谈梦想。");
		contentMap_5.put("headname", "信仰");

		Map<String, String> contentMap_6 = new HashMap<String, String>();
		contentMap_6.put("title", "磨和难");
		contentMap_6.put("status_img", "true");
		contentMap_6.put("start_time", "2011-04-11");
		contentMap_6.put("end_time", "2011-05-21");
		contentMap_6.put("name", "痛苦，挫折");
		contentMap_6.put("detail", "      曾常常听到这样的话语，幸福是建立在物质需求之上的，"
				+ "这个世界因为有了峭壁，才觉得平原的广阔，因为有了干旱，才渴望雨水的滋润。");
		contentMap_6.put("headname", "幸福");

		Map<String, String> contentMap_9 = new HashMap<String, String>();
		contentMap_9.put("title", "我们都是幸运的人");
		contentMap_9.put("status_img", "true");
		contentMap_9.put("start_time", "2011-04-11");
		contentMap_9.put("end_time", "2011-05-21");
		contentMap_9.put("name", "张北，李西，王东，谭北，居中正");
		contentMap_9.put("detail", "      在这个世界里，我们都是一群幸运的人，因为上天怜惜，"
				+ "赐与我们一副完整的身体，和健全的头脑，让我们在这世上走一遭，当是幸运无比的人。");
		contentMap_9.put("headname", "国政");

		Map<String, String> contentMap_0 = new HashMap<String, String>();
		contentMap_0.put("title", "我们都是幸运的人");
		contentMap_0.put("status_img", "true");
		contentMap_0.put("start_time", "2011-04-11");
		contentMap_0.put("end_time", "2011-05-21");
		contentMap_0.put("name", "张北，李西，王东，谭北，居中正");
		contentMap_0.put("detail", "      在这个世界里，我们都是一群幸运的人，因为上天怜惜，"
				+ "赐与我们一副完整的身体，和健全的头脑，让我们在这世上走一遭，当是幸运无比的人。");
		contentMap_0.put("headname", "国政");

		contentList.add(contentMap);
		contentList.add(contentMap_1);
		contentList.add(contentMap_2);
		contentList.add(contentMap_3);
		contentList.add(contentMap_4);
		contentList.add(contentMap_5);
		contentList.add(contentMap_6);
		contentList.add(contentMap_9);
		contentList.add(contentMap_0);

		isCurItem = new boolean[contentList.size()];

		for (int i = 0; i < isCurItem.length; i++) {
			isCurItem[i] = false;
		}

		Log.w("TAG", "AutoLoadActivity init() =========>>>>>> come in.");
		adapter = new FlexListAdapter();
	}

	public void onScroll(AbsListView v, int i, int j, int k) {
	}

	public void onScrollStateChanged(AbsListView v, int state) {
		if (state == OnScrollListener.SCROLL_STATE_IDLE) {
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (isCurItem[position]) {
			isCurItem[position] = false;
		} else {
			isCurItem[position] = true;
		}
		adapter.notifyDataSetChanged();
	}

	class FlexListAdapter extends BaseAdapter {
		int count = contentList.size();

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
				view = new FlexLinearLayout(ListFlexView.this, contentList
						.get(pos), pos, false);
			} else {
				view = (FlexLinearLayout) v;
				view.setWorkTitleLayout(contentList.get(pos), pos,
						isCurItem[pos]);
			}
			return view;
		}
	}

	public class FlexLinearLayout extends LinearLayout {
		public static final int BULE = 0xFF3D8CB8;

		private LinearLayout layout;
		private RelativeLayout titleLayout;
		private LinearLayout contentDetailLayout;

		private TextView contentDetailTitleText;
		private ImageView contentStatusImgView;
		private TextView contentStartTimeText;
		private TextView contentEndTimeText;
		private TextView contentNameText;
		private TextView contentDefailText;
		private TextView contentHeadnameText;

		/**
		 * 创建一个带有伸缩效果的LinearLayout
		 * 
		 * @param context
		 * @param contextDefail
		 *            内容详细
		 * @param position
		 *            该列所在列表的位置
		 * @param isCurrentItem
		 *            是否为伸展
		 */
		public FlexLinearLayout(Context context,
				final Map<String, String> contextDefail, final int position,
				boolean isCurrentItem) {
			super(context);

			layout = (LinearLayout) mInflater.inflate(
					R.layout.work_detail_row_layout, null);
			titleLayout = (RelativeLayout) layout
					.findViewById(R.id.workTitleLayout);
			contentDetailLayout = (LinearLayout) layout
					.findViewById(R.id.workDetailLayout);

			contentDetailTitleText = (TextView) layout
					.findViewById(R.id.workDetailTitle);
			contentStatusImgView = (ImageView) layout
					.findViewById(R.id.workStatusImg);
			contentStartTimeText = (TextView) layout
					.findViewById(R.id.workStartTime);
			contentEndTimeText = (TextView) layout
					.findViewById(R.id.workEndTime);
			contentNameText = (TextView) layout.findViewById(R.id.workName);
			contentDefailText = (TextView) layout.findViewById(R.id.workDetail);
			contentHeadnameText = (TextView) layout
					.findViewById(R.id.workHeadname);

			this.addView(layout);
			setWorkTitleLayout(contextDefail, position, isCurrentItem);
		}

		/**
		 * 设置该列的状态及样式
		 * 
		 * @param contentDefail
		 *            内容详细
		 * @param position
		 *            该列所在列表的位置
		 * @param isCurrentItem
		 *            是否为伸展
		 */
		public void setWorkTitleLayout(final Map<String, String> contentDefail,
				final int position, boolean isCurrentItem) {

			titleLayout
					.setBackgroundResource((position % 2 == 1) ? R.drawable.title_1
							: R.drawable.title_2);

			contentDetailTitleText.setText(contentDefail.get("title"));

			contentDetailTitleText.setTextColor((position % 2 == 0) ? BULE
					: Color.WHITE);

			contentStatusImgView.setImageResource((contentDefail
					.get("status_img").equals("true")) ? R.drawable.onebit_34
					: R.drawable.onebit_33);

			contentStatusImgView.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (contentDefail.get("status_img").equals("true")) {
						Random random = new Random();
						int stateID = random.nextInt(4);
						alterStateDialog(stateID);
					} else {
						contentDefail.put("status_img", "true");
						contentList.remove(position);
						contentList.add(position, contentDefail);
						adapter.notifyDataSetChanged();
					}
				}
			});

			if (isCurrentItem) {
				Log.d("TAG", "isCurrentItem" + position);
				contentStartTimeText.setText(contentDefail.get("start_time"));
				contentEndTimeText.setText(contentDefail.get("end_time"));
				contentNameText.setText(contentDefail.get("name"));
				contentDefailText.setText(contentDefail.get("detail"));
				contentHeadnameText.setText(contentDefail.get("headname"));
			}

			contentDetailLayout.setVisibility(isCurrentItem ? VISIBLE : GONE);
		}
	}

	/**
	 * 更改任务状态对话框
	 * 
	 * @param stateID
	 *            当前状态序列号
	 */
	private void alterStateDialog(int stateID) {
		/* 共四种状态，第五个为算法需要，具体算法请自己推算 */
		String[] stateAll = { "未读", "接收", "拒绝", "完成", "接收" };

		if (3 == stateID) {
			Toast.makeText(ListFlexView.this, "该任务已完成", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		String[] states = new String[2];
		for (int i = 0; i < 2; i++) {
			states[i] = stateAll[(stateID + i + 1)];
		}

		new AlertDialog.Builder(this).setTitle("当前状态：" + stateAll[stateID])
				.setItems(states, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				}).setNegativeButton("取消", null).show();
	}
}