package com.lilin.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 快速发布
 * 
 * @author lilin
 * @date 2011-8-23 下午11:35:44
 * @ClassName: tab1
 * @Description: TODO
 */
public class Tab1 extends Activity {
	String[] items = { "更新心情", "发布日志", "拍照上传" }; // 存放ListView中的选项内容
	int[] images = { R.drawable.p_status, R.drawable.p_diary,
			R.drawable.p_shoot };
	ProgressDialog progressDialog = null; // ProgressDialog对象引用
	View tab1_1 = null; // 心情
	EditText etStatus = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);

		ListView listView = (ListView) findViewById(R.id.lvPublish);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				switch (position) { // 判断点击的是哪一个选项
				case 0:
					/*---------------------更新心情----------------------------------*/
					// 将一个xml文件渲染成view，并设置成对话框的view
					LayoutInflater inflate = LayoutInflater.from(Tab1.this);
					tab1_1 = inflate.inflate(R.layout.tab1_1, null);

					new AlertDialog.Builder(Tab1.this)// 以弹出式对话框的形式发布兴趣
							.setTitle("更新心情")// 标题
							.setIcon(R.drawable.p_status)// 图标
							.setView(tab1_1)// 设置成对话框的view
							.setPositiveButton("发表",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {

										}
									})
							//
							.setNegativeButton("取消",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
										}
									}).show();
					/*--------------------------------------------------------------*/
					break;
				case 1: // 发表日志
					// Intent tab1_2 = new Intent(tab1.this, tab1_2.class);
					// tab1_2.putExtra("uno", uno);
					// startActivity(tab1_2);
					break;
				case 2: // 拍照上传
					// Intent tab1_3 = new Intent(tab1.this, tab1_3.class);
					// tab1_3.putExtra("uno", uno);
					// startActivity(tab1_3);
					break;
				}
			}

		});
	}

	/* 自定义适配器 */
	BaseAdapter adapter = new BaseAdapter() {
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			/*-------------------完全以代码的形式生成视图------------------------------------*/
			LinearLayout linearLayout = new LinearLayout(Tab1.this);// 创建LinearLayout
			linearLayout.setOrientation(LinearLayout.HORIZONTAL);
			linearLayout.setGravity(Gravity.CENTER);

			ImageView imageView = new ImageView(Tab1.this); // 创建ImageView
			imageView.setAdjustViewBounds(true);
			imageView.setImageResource(images[position]); // 设置ImageView显示的内容

			TextView textView = new TextView(Tab1.this);// 创建TextextViewiew
			textView.setPadding(10, 0, 0, 0);
			textView.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			textView.setTextAppearance(Tab1.this, R.style.title);
			textView.setText(items[position]); // 设置TextextViewiew显示的内容

			linearLayout.addView(imageView); // 将ImageView添加到线性布局中
			linearLayout.addView(textView);// 将textView添加到线性布局中
			return linearLayout;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public int getCount() {
			return items.length;
		}
	};

}