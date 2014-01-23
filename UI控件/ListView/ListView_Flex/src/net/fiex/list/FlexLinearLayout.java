package net.fiex.list;

import java.util.List;
import java.util.Map;
import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FlexLinearLayout extends LinearLayout {
	public static final int BULE = 0xFF3D8CB8;
	private List<Map<String, String>> contentList;
	private LinearLayout layout;
	private RelativeLayout titleLayout;
	private LinearLayout contentDetailLayout;
	private LayoutInflater mInflater;
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
			boolean isCurrentItem, List<Map<String, String>> contentList) {
		super(context);
		this.contentList = contentList;
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
		contentEndTimeText = (TextView) layout.findViewById(R.id.workEndTime);
		contentNameText = (TextView) layout.findViewById(R.id.workName);
		contentDefailText = (TextView) layout.findViewById(R.id.workDetail);
		contentHeadnameText = (TextView) layout.findViewById(R.id.workHeadname);

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

		contentStatusImgView.setImageResource((contentDefail.get("status_img")
				.equals("true")) ? R.drawable.onebit_34 : R.drawable.onebit_33);

		contentStatusImgView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (contentDefail.get("status_img").equals("true")) {
					Random random = new Random();
					int stateID = random.nextInt(4);
					// alterStateDialog(stateID);
				} else {
					contentDefail.put("status_img", "true");
					contentList.remove(position);
					contentList.add(position, contentDefail);
					// adapter.notifyDataSetChanged();
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