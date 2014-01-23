package com.lilin.ui;

import java.util.ArrayList;
import java.util.List;
import com.test.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * 主界面
 * 
 * @author lilin
 * @date 2011-12-22 上午08:21:16
 * @ClassName: MainView
 */
public class MainView extends Activity {
	private Gallery advGallery = null;
	private AdvGalleryAdapter myAdapter = null;
	private RadioGroup radioGroup = null;
	public List<String> imgURL = new ArrayList<String>();

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();

		myAdapter = new AdvGalleryAdapter(MainView.this, imgURL, advGallery);
		advGallery.setAdapter(myAdapter);
		// advGallery.setSelection(Integer.MAX_VALUE >> 1);
		advGallery
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						int j = arg2 % imgURL.size();
						System.out.println("j=" + j);
						// 更换背景
						radioGroup.check(j);
					}

					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});

		// 根据图片的个数动态添加RadioButton
		for (int i = 0; i < imgURL.size(); i++) {
			RadioButton radioButton = new RadioButton(MainView.this);
			radioButton.setId(i);
			radioButton.setButtonDrawable(R.drawable.adv_gallery_mark_selector);
			radioButton.setClickable(false);
			radioGroup.addView(radioButton);
		}

	}

	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.home_advs_gallery_mark);
		advGallery = (Gallery) findViewById(R.id.home_advs_gallery);
		imgURL.add("http://www.baidu.com/img/baidu_sylogo1.gif");
		imgURL.add("http://www.iteye.com/images/logo.gif?1308833136");
		imgURL.add("http://csdnimg.cn/www/images/csdnindex_logo.gif");
		imgURL.add("http://www.baidu.com/img/baidu_sylogo1.gif");
		imgURL.add("http://www.iteye.com/images/logo.gif?1308833136");
		imgURL.add("http://csdnimg.cn/www/images/csdnindex_logo.gif");

	}
}