package com.lilin.tabwidget;

import java.util.ArrayList;
import java.util.HashMap;

public class GetDataList {
	public static ArrayList<HashMap<String, Object>> getDataList(String[] name) {
		ArrayList<HashMap<String, Object>> dataArrayList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < name.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", name[i]);
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
}
