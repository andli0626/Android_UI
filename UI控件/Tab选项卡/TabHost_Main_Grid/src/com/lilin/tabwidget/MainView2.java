package com.lilin.tabwidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 主界面
 * 
 * @author lilin
 * @date 2011-7-25 上午09:24:55
 * @ClassName: MainView2
 * @Description: TODO
 */
public class MainView2 extends Activity {
	private GridView gridView = null;
	String[] item_name1 = { "公文处理", "公务邮件", "通知公告", "附件管理", "系统配置", "数据同步",
			"程序更新" };// 单项的名字
	int[] item_images1 = { R.drawable.tab11, R.drawable.tab12,
			R.drawable.tab21, R.drawable.tab31, R.drawable.tab41,
			R.drawable.tab42, R.drawable.tab43 };// 单项的图片

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.mainview2);
		setTitle("主界面2");
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏注意,这个设置必须放在设置布局前面,不然会报错
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, GetDataList
				.getDataList(item_name1, item_images1), R.layout.mainview_item,
				new String[] { "images", "name" }, new int[] { R.id.item_image,
						R.id.item_text });
		gridView = (GridView) this.findViewById(R.id.gv2);
		SetGridView.setGridView(gridView, 3, 10, 10, 0);
		gridView.setAdapter(simpleAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				switch (position + 1) {
				case 1:// 公文处理
					break;
				case 2:// 公务邮件
					break;
				case 3:// 通知公告
					break;
				case 4:// 附件管理
					break;
				case 5:// 拍照
					break;
				case 6:// 录音
					break;
				case 7:// 通讯录
					break;
				case 8:// 日程安排
					break;
				case 9:// 系统配置
					break;
				case 10:// 程序更新
					break;
				default:
					break;
				}
			}
		});
	}

}