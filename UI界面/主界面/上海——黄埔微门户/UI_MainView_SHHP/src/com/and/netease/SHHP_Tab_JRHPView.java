package com.and.netease;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.and.netease.utils.GridViewHelp;

public class SHHP_Tab_JRHPView extends Activity implements OnClickListener {
	// 外滩 外滩源 南京路 人民广场 淮海中路 新天地 文化广场 思南路 8号桥 豫园 老码头 田子坊 世博滨江
	String[] item_name = { "外滩", "外滩源", "南京路", "人民广场", "淮海中路", "新天地", "文化广场",
			"思南路", "8号桥" };// 单项的名字
	// 主界面上每一项的图片
	int[] item_images = { R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1, R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1, R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1 };// 单项的图片

	LinearLayout cqgkLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shhp_jrhpview);
		initViews();

		cqgkLayout = (LinearLayout) findViewById(R.id.cqgk);
		cqgkLayout.setClickable(true);

		cqgkLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(SHHP_Tab_JRHPView.this, "城区概括", Toast.LENGTH_LONG)
						.show();
			}
		});

	}

	private void initViews() {
		// GridView初始化
		GridView gv = (GridView) this.findViewById(R.id.gridview);
		// 设置GridView的相应参数
		GridViewHelp.setGridView(gv,// 布局对象视图
				2,// 列数
				0,// 垂直间距
				0,// 水平间距
				0// 背景色
				);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				GridViewHelp.getDataList(item_name, item_images),
				R.layout.shhp_jrhp_gridview_item, new String[] { "images",
						"name" }, new int[] { R.id.item_image, R.id.item_text });
		gv.setAdapter(simpleAdapter);
	}

	@Override
	public void onClick(View v) {

	}
}
