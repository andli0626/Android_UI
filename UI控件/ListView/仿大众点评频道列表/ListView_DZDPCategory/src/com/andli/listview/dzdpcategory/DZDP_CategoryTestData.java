package com.andli.listview.dzdpcategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author lilin
 * @date 2012-12-7 上午9:56:06
 * @annotation 类别的测试数据
 */
public class DZDP_CategoryTestData {

	public static List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", "分类" + i);
			map.put("img", R.drawable.listitem_left_img);
			list.add(map);
		}
		return list;
	}
}
