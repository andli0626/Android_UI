package com.andli.customlistview.uixml;

import java.io.IOException;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author lilin
 * @date 2012-12-15 下午10:09:30
 * @annotation ListView的每一项样式---用代码来实现XML布局
 */
public class FileListItemXML extends LinearLayout {

	public ImageView mImageView;
	public TextView midTextView;
	protected Bitmap fileIcon;
	protected Bitmap folderIcon;
	protected Bitmap back2ParentIcon;

	public FileListItemXML(Context context, Map<String, Object> mdata) {
		super(context);
		this.setOrientation(HORIZONTAL);

		try {
			fileIcon = BitmapFactory.decodeStream(context.getAssets().open(
					"file32x32.png"));
			folderIcon = BitmapFactory.decodeStream(context.getAssets().open(
					"folder32x32.png"));
			back2ParentIcon = BitmapFactory.decodeStream(context.getAssets()
					.open("parent32x32.png"));
		} catch (IOException e) {
			Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}

		mImageView = new ImageView(context);
		midTextView = new TextView(context);
		midTextView.setTextSize(18);
		midTextView.setTextColor(Color.WHITE);

		mImageView.setLayoutParams(new LayoutParams(32, 32));

		String title = (String) mdata.get("title");
		boolean isParent = (Boolean) mdata.get("isParent");
		boolean isFile = (Boolean) mdata.get("isFile");

		midTextView.setText(title);
		mImageView.setImageBitmap(isParent ? back2ParentIcon
				: isFile ? fileIcon : folderIcon);

		LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		addView(mImageView, params);
		addView(midTextView, params);

	}

}
