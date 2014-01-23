package com.andli.uitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

	public MyView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		RectF oval = new RectF(10, 10, 100, 100);
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		canvas.drawOval(oval, paint);

		paint.setColor(Color.YELLOW);
		canvas.drawText("大家好!", 40, 40f, paint);
		super.onDraw(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		System.out.println("touch");
		return super.onTouchEvent(event);
	}

}
