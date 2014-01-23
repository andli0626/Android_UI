package com.epoint.android.customui.help;

import java.io.IOException;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.Toast;

public class CustomHelp {

	// 设置selector（代码实现）——读取Drawable下的图片资源
	public static StateListDrawable newSelector(Context context, int idNormal,
			int idPressed, int idFocused, int idUnable) {
		StateListDrawable bg = new StateListDrawable();
		Drawable normal = idNormal == -1 ? null : context.getResources()
				.getDrawable(idNormal);
		Drawable pressed = idPressed == -1 ? null : context.getResources()
				.getDrawable(idPressed);
		Drawable focused = idFocused == -1 ? null : context.getResources()
				.getDrawable(idFocused);
		Drawable unable = idUnable == -1 ? null : context.getResources()
				.getDrawable(idUnable);
		// View.PRESSED_ENABLED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_pressed,
				android.R.attr.state_enabled }, pressed);
		// View.ENABLED_FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_enabled,
				android.R.attr.state_focused }, focused);
		// View.ENABLED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_enabled }, normal);
		// View.FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_focused }, focused);
		// View.WINDOW_FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_window_focused }, unable);
		// View.EMPTY_STATE_SET
		bg.addState(new int[] {}, normal);
		return bg;
	}

	// 设置selector（代码实现）——读取assert下的图片资源
	public static StateListDrawable newSelector(Context context,
			Drawable idNormal, Drawable idPressed, Drawable idFocused,
			Drawable idUnable) {
		StateListDrawable bg = new StateListDrawable();
		Drawable normal = idNormal == null ? null : idNormal;
		Drawable pressed = idPressed == null ? null : idPressed;
		Drawable focused = idFocused == null ? null : idFocused;
		Drawable unable = idUnable == null ? null : idUnable;
		// View.PRESSED_ENABLED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_pressed,
				android.R.attr.state_enabled }, pressed);
		// View.ENABLED_FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_enabled,
				android.R.attr.state_focused }, focused);
		// View.ENABLED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_enabled }, normal);
		// View.FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_focused }, focused);
		// View.WINDOW_FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_window_focused }, unable);
		// View.EMPTY_STATE_SET
		bg.addState(new int[] {}, normal);
		return bg;
	}

	// 设置selector（代码实现）——读取assert下的图片资源
	public static StateListDrawable newSelector(Context context,
			String idNormal, String idPressed, String idFocused, String idUnable) {

		StateListDrawable bg = new StateListDrawable();
		Drawable normal = idNormal == "" ? null : getImgFromAsserts(context,
				idNormal);
		Drawable pressed = idPressed == "" ? null : getImgFromAsserts(context,
				idPressed);
		Drawable focused = idFocused == "" ? null : getImgFromAsserts(context,
				idFocused);
		Drawable unable = idUnable == "" ? null : getImgFromAsserts(context,
				idUnable);
		// View.PRESSED_ENABLED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_pressed,
				android.R.attr.state_enabled }, pressed);
		// View.ENABLED_FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_enabled,
				android.R.attr.state_focused }, focused);
		// View.ENABLED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_enabled }, normal);
		// View.FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_focused }, focused);
		// View.WINDOW_FOCUSED_STATE_SET
		bg.addState(new int[] { android.R.attr.state_window_focused }, unable);
		// View.EMPTY_STATE_SET
		bg.addState(new int[] {}, normal);
		return bg;
	}

	// 从Assert目录下获取图片
	public static Drawable getImgFromAsserts(Context con, String filename) {

		try {
			return new BitmapDrawable(BitmapFactory.decodeStream(con
					.getAssets().open(filename)));
		} catch (IOException e) {
			Toast.makeText(con, "assets下找不到图片：" + e.toString(),
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		return null;
	}

	public static Drawable[] getImgsFromAsserts(Context con, String filename[]) {

		try {
			Drawable[] imgs = new Drawable[filename.length];
			for (int i = 0; i < filename.length; i++) {
				imgs[i] = new BitmapDrawable(BitmapFactory.decodeStream(con
						.getAssets().open(filename[i])));
			}
			return imgs;
		} catch (IOException e) {
			Toast.makeText(con, "assets下找不到图片：" + e.toString(),
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		return null;
	}

}
