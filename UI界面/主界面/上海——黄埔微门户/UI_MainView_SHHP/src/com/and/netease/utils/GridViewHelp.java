package com.and.netease.utils;

import java.util.ArrayList;
import java.util.HashMap;

import android.view.Gravity;
import android.widget.GridView;

public class GridViewHelp {

	public static ArrayList<HashMap<String, Object>> getDataList(String[] name) {
		ArrayList<HashMap<String, Object>> dataArrayList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < name.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", name[i]);
			// map.put("iamge", image[i]);
			dataArrayList.add(map);
		}
		return dataArrayList;
	}

	public static ArrayList<HashMap<String, Object>> getDataList(String[] name,
			int image[]) {
		ArrayList<HashMap<String, Object>> dataArrayList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < name.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("images", image[i]);
			map.put("name", name[i]);
			dataArrayList.add(map);
		}
		return dataArrayList;
	}

	public static void setGridView(GridView gridView,// 布局
			int columns,// 列数
			int verticalspacing,// 垂直间距
			int hrizontalspacing,// 水平间距
			int color)// 背景色
	{
		gridView.setNumColumns(columns);
		gridView.setGravity(Gravity.CENTER);
		gridView.setVerticalSpacing(verticalspacing);
		gridView.setHorizontalSpacing(hrizontalspacing);
		gridView.setBackgroundColor(color);
	}
}
