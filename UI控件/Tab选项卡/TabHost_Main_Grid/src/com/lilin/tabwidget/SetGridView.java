package com.lilin.tabwidget;

import android.view.Gravity;
import android.widget.GridView;

public class SetGridView {
	public static void setGridView(GridView gridView,// 布局
			int columns,// 列数
			int verticalspacing,// 垂直间距
			int hrizontalspacing,// 水平间距
			int color// 背景色
	) {
		// TODO Auto-generated method stub

		gridView.setNumColumns(columns);
		gridView.setGravity(Gravity.CENTER);
		gridView.setVerticalSpacing(verticalspacing);
		gridView.setHorizontalSpacing(hrizontalspacing);
		gridView.setBackgroundColor(color);
	}
}
