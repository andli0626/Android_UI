package org.news.utils;

import android.content.Context;

public class DisplayUtils {
	
	/**讲px转换成dip**/
	public int pxToDip(Context context, int pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue * scale + 0.5f);
	}

}
