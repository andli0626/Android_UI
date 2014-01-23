package com.lilin.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Main extends Activity {
	private GridView gv = null;// 主界面布局：网格布局
	// 主界面上每一项的名字
	String[] item_name = { "问题上报", "监督任务", "简易执法", "地图浏览", "法律法规", "办公助理",
			"语音呼叫", "数据同步", "系统设置" };// 单项的名字
	// 主界面上每一项的图片
	int[] item_images = { R.drawable.p1, R.drawable.p2, R.drawable.p3,
			R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7,
			R.drawable.p8, R.drawable.p9 };// 单项的图片

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		gv = (GridView) this.findViewById(R.id.gridview);
		// 设置GridView的相应参数
		GridViewHelp.setGridView(gv,// 布局对象视图
				3,// 列数
				10,// 垂直间距
				10,// 水平间距
				0// 背景色
				);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				GridViewHelp.getDataList(item_name, item_images),
				R.layout.mainview_item, new String[] { "images", "name" },
				new int[] { R.id.item_image, R.id.item_text });
		gv.setAdapter(simpleAdapter);
		// 点击事件
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				position = position + 1;
				switch (position) {
				case 1:
				// 1
				{
					Toast.makeText(Main.this, String.valueOf(position),
							Toast.LENGTH_LONG).show();
				}

					break;
				case 2:
				// 2
				{
					Toast.makeText(Main.this, String.valueOf(position),
							Toast.LENGTH_LONG).show();
				}
					break;
				default:
					break;
				}
			}
		});
	}
}