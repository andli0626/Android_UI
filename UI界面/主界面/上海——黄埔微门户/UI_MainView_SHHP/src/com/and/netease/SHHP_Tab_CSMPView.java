package com.and.netease;

import com.and.netease.utils.GridViewHelp;
import com.epoint.mobileui.focusimg.FocusImgView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

public class SHHP_Tab_CSMPView extends Activity {
	RelativeLayout layout;

	RelativeLayout contentLayout;

	int focus_imgs[] = { R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1, R.drawable.csmp_1, R.drawable.csmp_1, };

	// 外滩 外滩源 南京路 人民广场 淮海中路 新天地 文化广场 思南路 8号桥 豫园 老码头 田子坊 世博滨江
	String[] focus_names = { "外滩", "外滩源", "南京路", "人民广场", "淮海中路" };// 单项的名字

	int item_imgs[] = { R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1, R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1, R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1, R.drawable.csmp_1, R.drawable.csmp_1,
			R.drawable.csmp_1, R.drawable.csmp_1 };

	// 外滩 外滩源 南京路 人民广场 淮海中路 新天地 文化广场 思南路 8号桥 豫园 老码头 田子坊 世博滨江
	String[] item_names = { "外滩", "外滩源", "南京路", "人民广场", "淮海中路", "新天地", "文化广场",
			"思南路", "8号桥", "豫园", "老码头", "田子坊", "世博滨江" };// 单项的名字

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shhp_csmpview);

		initUI();
	}

	private void initUI() {

		layout = (RelativeLayout) findViewById(R.id.layout_title_bar);

		// 添加焦点图
		contentLayout = (RelativeLayout) findViewById(R.id.layout_content);
		Bitmap bmps[] = new Bitmap[focus_imgs.length];
		for (int i = 0; i < bmps.length; i++) {
			bmps[i] = BitmapFactory.decodeResource(getResources(),
					focus_imgs[i]);
		}

		FocusImgView focusImgView = new FocusImgView(this, focus_names, bmps);
		// focusImgView.getFocusimg_title().setWidth(40);

		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		contentLayout.addView(focusImgView, params);

		// GridView初始化
		GridView gv = (GridView) this.findViewById(R.id.gridview);
		// 设置GridView的相应参数
		GridViewHelp.setGridView(gv,// 布局对象视图
				3,// 列数
				10,// 垂直间距d
				10,// 水平间距
				0// 背景色
				);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				GridViewHelp.getDataList(item_names, item_imgs),
				R.layout.shhp_csmp_gridview_item, new String[] { "images",
						"name" }, new int[] { R.id.item_image, R.id.item_text });
		gv.setAdapter(simpleAdapter);
		// gv.getLayoutParams().width = 5;

	}
}
