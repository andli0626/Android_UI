package com.lilin.gallary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

import com.amaker.test.R;

/**
 * gallery 画廊
 * 
 * @author lilin
 * @date 2011-8-30 上午10:35:06
 * @ClassName: Main
 * @Description: TODO
 */
public class Main extends Activity implements OnItemSelectedListener,
		ViewFactory {

	private ImageSwitcher imageSwitcher;
	Gallery gallery;
	private Integer[] thumbID = { R.drawable.sample_thumb_0,
			R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
			R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
			R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
			R.drawable.sample_thumb_7 };

	private Integer[] imageID = { R.drawable.sample_0, R.drawable.sample_1,
			R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4,
			R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7 };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// setTitle("图片浏览");
		// setTitleColor(Color.YELLOW);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 无信息栏
		setContentView(R.layout.main);
		getView();
		imageSwitcher.setFactory(this);
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));

		gallery.setAdapter(new ImageAdapter(this));
		gallery.setOnItemSelectedListener(this);

	}

	public void getView() {
		imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
		gallery = (Gallery) findViewById(R.id.gallery);
	}

	// 自定义图片适配器
	public class ImageAdapter extends BaseAdapter {
		private Context context;

		public ImageAdapter(Context c) {
			context = c;
		}

		public int getCount() {
			return thumbID.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(thumbID[position]);
			imageView.setAdjustViewBounds(true);
			imageView.setLayoutParams(new Gallery.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			imageView.setBackgroundResource(R.drawable.picture_frame);
			return imageView;
		}

	}

	// imageSwitcher的单击事件
	@Override
	public void onItemSelected(AdapterView<?> adapter, View v, int position,
			long id) {
		imageSwitcher.setImageResource(imageID[position]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	@Override
	public View makeView() {
		ImageView i = new ImageView(this);
		i.setBackgroundColor(0xFF000000);
		i.setScaleType(ImageView.ScaleType.FIT_CENTER);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return i;
	}
}