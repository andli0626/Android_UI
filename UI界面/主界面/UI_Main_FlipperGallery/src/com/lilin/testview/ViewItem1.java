package com.lilin.testview;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;

import com.droidful.flinggallery.R;
import com.lilin.flipper.FlingGallery;
import com.lilin.util.GetDataList;
import com.lilin.util.SetGridView;

public class ViewItem1 extends TableLayout {
	String[] item_name = { "问题上报", "监督任务", "简易执法", "地图浏览", "法律法规", "办公助理",
			"语音呼叫", "数据同步", "系统设置" };// 单项的名字
	int[] item_images = { R.drawable.wtsb, R.drawable.wdrw, R.drawable.jyzf,
			R.drawable.yysb, R.drawable.dtll, R.drawable.lmqw, R.drawable.yyhj,
			R.drawable.jrts, R.drawable.sjtb };// 单项的图片

	public ViewItem1(Context context, int pos, final FlingGallery flingGallery) {
		super(context);

		LayoutInflater inflater = LayoutInflater.from(context);
		RelativeLayout view2 = (RelativeLayout) inflater.inflate(
				R.layout.viewitem1, null);
		GridView gv = (GridView) view2.findViewById(R.id.gridview);
		// 设置GridView的相应参数
		SetGridView.setGridView(gv,// 布局对象视图
				3,// 列数
				7,// 垂直间距
				7,// 水平间距
				0,// 背景色
				0,// 背景图片
				Gravity.CENTER// 位置
				);
		SimpleAdapter simpleAdapter = new SimpleAdapter(context, GetDataList
				.getDataList(item_name, item_images), R.layout.mainview_item,
				new String[] { "images", "name" }, new int[] { R.id.item_image,
						R.id.item_text });
		gv.setAdapter(simpleAdapter);
		this.addView(view2);
	}
}