package com.lilin.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.lilin.lc.ListCheckBoxAdp.ViewHolder;

/**
 * 
 * @author lilin
 * @date 2011-7-29 下午02:32:46
 * @ClassName: Main
 * @Description: TODO
 */
public class Main extends Activity {
	private ListView mListView;
	private StringBuffer stringBuffer;
	private EditText opinionEditText;
	public List<Map<String, Object>> mData;
	public static String opition[] = { "选项1", "选项2", "选项3", "选项4", "选项5", "选项6",
			"选项7", "选项8", "选项9" };
	public static boolean isSelect[] = new boolean[opition.length];// 初始复选情况

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();

		ListCheckBoxAdp adapter = new ListCheckBoxAdp(this, mData);
		mListView.setAdapter(adapter);
		mListView.setItemsCanFocus(false);
		mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ViewHolder vHollder = (ViewHolder) view.getTag();
				// 在每次获取点击的item时将对于的checkbox状态改变，同时修改map的值。
//				vHollder.cBox.toggle();// 反转当前视图的选中状态/
				
				
//				String s = "";
//				if (vHollder.cBox.isChecked() == true) {
//					isSelect[position] = true;
//
//				} else {
//					isSelect[position] = false;
//				}
				for (int i = 0; i < isSelect.length; i++) {
					if(i==position){
						isSelect[i]=true;
					}else{
						isSelect[i]=false;
					}
				}
				
				
				for (int i = 0; i < isSelect.length; i++) {
					if(isSelect[i]){
						try {
							opinionEditText.setText(i+"");
						} catch (Exception e) {
						}
					}
					
				}
				
			}
		});
	}

	private void init() {
		stringBuffer = new StringBuffer();
		mListView = (ListView) findViewById(R.id.lv);
		opinionEditText = (EditText) findViewById(R.id.task_opinion);
		for (int i = 0; i < opition.length; i++) {
			isSelect[i] = false;
		}
		// 测试数据
		mData = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < opition.length; i++) {
			map = new HashMap<String, Object>();
			map.put("title", opition[i]);
			mData.add(map);
		}
	}
}
