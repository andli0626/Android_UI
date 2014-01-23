package org.news.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.news.utils.DisplayUtils;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //获取资源文件数组中头部导航信息
        String [] categoryArrays = getResources().getStringArray(R.array.categories);
        List <HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = null;
		for (int i = 0; i < categoryArrays.length; i++) {
			map = new HashMap<String, String>();
			map.put("category_title", categoryArrays[i]);
			list.add(map);
		}
        //创建一个视图用于显示新闻头部导航信息
        GridView category = new GridView(this);
        //设置GridView中每一列的宽度
        int widthDip = new DisplayUtils().pxToDip(this, 55);
        category.setColumnWidth(widthDip);
        //设置GridView中的列数
        category.setNumColumns(GridView.AUTO_FIT);
        //设置对齐方式
        category.setGravity(Gravity.CENTER);
        //设置GridView焦点事件
        category.setSelector(new ColorDrawable(Color.TRANSPARENT));
        //设置布局参数  width height
        int width = widthDip * categoryArrays.length;
		LayoutParams params = new LayoutParams(width, LayoutParams.WRAP_CONTENT);
        category.setLayoutParams(params);
        //为GridView绑定适配器
        category.setAdapter(new CustomSimpleAdapter(this, list, R.layout.category_title, new String[]{"category_title"}, new int[]{R.id.category_title}));
        //将GridView添加进布局中
        LinearLayout layout = (LinearLayout) findViewById(R.id.category_layout);
        layout.addView(category);
        //设置GridViewItemOnClick监听事件
        category.setOnItemClickListener(getCategoryOnItemClick);
        //给新闻列表填充数据
        List <HashMap<String,String>> newslist_item = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> newslist_item_map = null;
		for (int i = 0; i < categoryArrays.length; i++) {
			newslist_item_map = new HashMap<String, String>();
			newslist_item_map.put("newslist_item_title", "涛涛新闻客户端要发布了");
			newslist_item_map.put("newslist_item_zhaiyao", "恭喜恭喜");
			newslist_item_map.put("newslist_item_zuozhe", "小小吴");
			newslist_item_map.put("newslist_item_datatime", "2012-08-22 17:55");
			newslist_item.add(newslist_item_map);
		}
        ListView news_list = (ListView) findViewById(R.id.news_list);
        news_list.setAdapter(new SimpleAdapter(this,newslist_item,R.layout.news_list_item,new String[]{"newslist_item_title","newslist_item_zhaiyao","newslist_item_zuozhe","newslist_item_datatime"},new int[]{R.id.newslist_item_title,R.id.newslist_item_zhaiyao,R.id.newslist_item_zuozhe,R.id.newslist_item_datatime}));
        news_list.setOnItemClickListener(getNewsListOnItemClick);
        
	}

	private OnItemClickListener getCategoryOnItemClick = new  OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				TextView text;
				for (int i = 0; i < parent.getCount(); i++) {
					text = (TextView) parent.getChildAt(i);
					text.setTextColor(0XFFADB2AD);
					text.setBackgroundDrawable(null);
				}
				text = (TextView) view;
				text.setTextColor(Color.WHITE);
				text.setBackgroundResource(R.drawable.image_categorybar_item_selected_background);
			}
	};
    
	private OnItemClickListener getNewsListOnItemClick = new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivity(new Intent(MainActivity.this,NewsDetailActivity.class));
			}
	};
	
    
}