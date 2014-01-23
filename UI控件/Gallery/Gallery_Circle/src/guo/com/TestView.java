package guo.com;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Gallery.LayoutParams;

public class TestView extends Activity {
	Gallery gallery;

	private Integer[] mThumbIds = { R.drawable.menu1, R.drawable.menu2,
			R.drawable.menu3, R.drawable.menu4, R.drawable.menu5,
			R.drawable.menu6, R.drawable.menu7 };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));
	}

	public class ImageAdapter extends BaseAdapter {

		private Context myContext;

		private ImageAdapter(Context context) {
			myContext = context;
		}

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;// 要是gallery循环下去，需要修改两处：这里是第一处
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView i = new ImageView(myContext);
			// 第2处改进，通过取余来循环取得mThumbIds数组中的图像资源ID
			i.setImageResource(mThumbIds[position % mThumbIds.length]);
			// i.setImageResource(mThumbIds[position]);
			i.setScaleType(ImageView.ScaleType.FIT_XY);
			i.setLayoutParams(new Gallery.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			return i;
		}

	}
}