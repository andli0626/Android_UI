package com.lilin.flipper;

import android.content.Context;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class FlingGallery extends FrameLayout {
	// 常量
	private final int swipe_min_distance = 120;
	private final int swipe_max_off_path = 250;
	private final int swipe_threshold_veloicty = 400;
	// 内边距
	private int paddingWidth = 0;
	private int animationDuration = 250;
	private float snapBorderRatio = 0.5f;
	// 是否循环滑动：默认循环
	private boolean isCircular = true;
	private int galleryWidth = 0;
	private boolean isTouch = false;
	private boolean isDragging = false;
	private float curOffset = 0.0f;
	private long scrollTimeStamp = 0;
	private int flingDirection = 0;
	private int curPos = 0;
	private int curViewNum = 0;

	private Context context;
	private Adapter galleryAdp;
	private FlingGalleryView[] flingGalleryView;
	private FlingAnimation flingAnimation;
	private GestureDetector mGestureDetector;
	private Interpolator mDecelerateInterpolater;

	// 构造函数
	public FlingGallery(Context context) {
		super(context);
		this.context = context;

		galleryAdp = null;
		// 声明3个视图循环显示
		flingGalleryView = new FlingGalleryView[3];
		flingGalleryView[0] = new FlingGalleryView(0, this);
		flingGalleryView[1] = new FlingGalleryView(1, this);
		flingGalleryView[2] = new FlingGalleryView(2, this);

		flingAnimation = new FlingAnimation();
		mGestureDetector = new GestureDetector(new FlingGestureDetector());
		mDecelerateInterpolater = AnimationUtils.loadInterpolator(context,
				android.R.anim.decelerate_interpolator);
	}

	// 适配器设置
	public void setAdapter(Adapter adapter) {
		galleryAdp = adapter;
		curPos = 0;
		curViewNum = 0;

		// Load the initial views from adapter
		flingGalleryView[0].recycleView(curPos);
		flingGalleryView[1].recycleView(getNextPos(curPos));
		flingGalleryView[2].recycleView(getPrePos(curPos));

		// Pos views at correct starting offsets
		flingGalleryView[0].setOffset(0, 0, curViewNum);
		flingGalleryView[1].setOffset(0, 0, curViewNum);
		flingGalleryView[2].setOffset(0, 0, curViewNum);
	}

	public void setPaddingWidth(int viewPaddingWidth) {
		paddingWidth = viewPaddingWidth;
	}

	public void setAnimationDuration(int animationDuration) {
		this.animationDuration = animationDuration;
	}

	public void setSnapBorderRatio(float snapBorderRatio) {
		this.snapBorderRatio = snapBorderRatio;
	}

	// 设置是否循环
	public void setIsGalleryCircular(boolean isCircular) {
		if (this.isCircular != isCircular) {
			this.isCircular = isCircular;

			if (curPos == getFirstPos()) {
				// We need to reload the view immediately to the left to change
				// it to circular view or blank
				flingGalleryView[getPrevViewNum(curViewNum)]
						.recycleView(getPrePos(curPos));
			}

			if (curPos == getLastPos()) {
				// We need to reload the view immediately to the right to change
				// it to circular view or blank
				flingGalleryView[getNextViewNum(curViewNum)]
						.recycleView(getNextPos(curPos));
			}
		}
	}

	public int getGalleryCount() {
		return (galleryAdp == null) ? 0 : galleryAdp.getCount();
	}

	public int getFirstPos() {
		return 0;
	}

	public int getLastPos() {
		return (getGalleryCount() == 0) ? 0 : getGalleryCount() - 1;
	}

	private int getPrePos(int relativePos) {
		int prePos = relativePos - 1;

		if (prePos < getFirstPos()) {
			prePos = getFirstPos() - 1;
			if (isCircular == true) {
				prePos = getLastPos();
			}
		}

		return prePos;
	}

	private int getNextPos(int relativePos) {
		int nextPos = relativePos + 1;

		if (nextPos > getLastPos()) {
			nextPos = getLastPos() + 1;

			if (isCircular == true) {
				nextPos = getFirstPos();
			}
		}

		return nextPos;
	}

	private int getPrevViewNum(int relativeViewNum) {
		return (relativeViewNum == 0) ? 2 : relativeViewNum - 1;
	}

	private int getNextViewNum(int relativeViewNum) {
		return (relativeViewNum == 2) ? 0 : relativeViewNum + 1;
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);

		// Calculate our view width
		galleryWidth = right - left;

		if (changed == true) {
			// Pos views at correct starting offsets
			flingGalleryView[0].setOffset(0, 0, curViewNum);
			flingGalleryView[1].setOffset(0, 0, curViewNum);
			flingGalleryView[2].setOffset(0, 0, curViewNum);
		}
	}

	private int getViewOffset(int ViewNum, int relativeViewNum) {
		// Determine width including configured padding width
		int offsetWidth = galleryWidth + paddingWidth;

		// Pos the previous view one measured width to left
		if (ViewNum == getPrevViewNum(relativeViewNum)) {
			return offsetWidth;
		}

		// Pos the next view one measured width to the right
		if (ViewNum == getNextViewNum(relativeViewNum)) {
			return offsetWidth * -1;
		}

		return 0;
	}

	void movePrevious() {
		// Slide to previous view
		flingDirection = 1;
		processGesture();
	}

	void moveNext() {
		// Slide to next view
		flingDirection = -1;
		processGesture();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_LEFT:
			movePrevious();
			return true;

		case KeyEvent.KEYCODE_DPAD_RIGHT:
			moveNext();
			return true;

		case KeyEvent.KEYCODE_DPAD_CENTER:
		case KeyEvent.KEYCODE_ENTER:
		}

		return super.onKeyDown(keyCode, event);
	}

	public boolean onGalleryTouchEvent(MotionEvent event) {
		boolean consumed = mGestureDetector.onTouchEvent(event);

		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (isTouch || isDragging) {
				processScrollSnap();
				processGesture();
			}
		}

		return consumed;
	}

	void processGesture() {
		int newViewNum = curViewNum;
		int reloadViewNum = 0;
		int reloadPos = 0;

		isTouch = false;
		isDragging = false;

		if (flingDirection > 0) {
			if (curPos > getFirstPos() || isCircular == true) {
				// Determine previous view and outgoing view to recycle
				newViewNum = getPrevViewNum(curViewNum);
				curPos = getPrePos(curPos);
				reloadViewNum = getNextViewNum(curViewNum);
				reloadPos = getPrePos(curPos);
			}
		}

		if (flingDirection < 0) {
			if (curPos < getLastPos() || isCircular == true) {
				// Determine the next view and outgoing view to recycle
				newViewNum = getNextViewNum(curViewNum);
				curPos = getNextPos(curPos);
				reloadViewNum = getPrevViewNum(curViewNum);
				reloadPos = getNextPos(curPos);
			}
		}

		if (newViewNum != curViewNum) {
			curViewNum = newViewNum;

			// Reload outgoing view from adapter in new Pos
			flingGalleryView[reloadViewNum].recycleView(reloadPos);
		}

		// Ensure input focus on the current view
		flingGalleryView[curViewNum].requestFocus();

		// Run the slide animations for view transitions
		flingAnimation.prepareAnimation(curViewNum);
		this.startAnimation(flingAnimation);

		// Reset fling state
		flingDirection = 0;
	}

	void processScrollSnap() {
		// Snap to next view if scrolled passed snap Pos
		float rollEdgeWidth = galleryWidth * snapBorderRatio;
		int rollOffset = galleryWidth - (int) rollEdgeWidth;
		int currentOffset = flingGalleryView[curViewNum].getCurrentOffset();

		if (currentOffset <= rollOffset * -1) {
			// Snap to previous view
			flingDirection = 1;
		}

		if (currentOffset >= rollOffset) {
			// Snap to next view
			flingDirection = -1;
		}
	}

	private class FlingAnimation extends Animation {
		private boolean isAnimationInProgres;
		private int relativeViewNum;
		private int initOffset;
		private int targetOffset;
		private int targetDistance;

		public FlingAnimation() {
			isAnimationInProgres = false;
			relativeViewNum = 0;
			initOffset = 0;
			targetOffset = 0;
			targetDistance = 0;
		}

		public void prepareAnimation(int relativeViewNum) {
			// If we are animating relative to a new view
			if (this.relativeViewNum != relativeViewNum) {
				if (isAnimationInProgres == true) {
					// We only have three views so if requested again to animate
					// in same direction we must snap
					int newDirection = (relativeViewNum == getPrevViewNum(relativeViewNum)) ? 1
							: -1;
					int animDirection = (targetDistance < 0) ? 1 : -1;

					// If animation in same direction
					if (animDirection == newDirection) {
						// Ran out of time to animate so snap to the target
						// offset
						flingGalleryView[0].setOffset(targetOffset, 0,
								relativeViewNum);
						flingGalleryView[1].setOffset(targetOffset, 0,
								relativeViewNum);
						flingGalleryView[2].setOffset(targetOffset, 0,
								relativeViewNum);
					}
				}

				// Set relative view number for animation
				this.relativeViewNum = relativeViewNum;
			}

			// Note: In this implementation the targetOffset will always be zero
			// as we are centering the view; but we include the calculations of
			// targetOffset and targetDistance for use in future implementations

			initOffset = flingGalleryView[relativeViewNum].getCurrentOffset();
			targetOffset = getViewOffset(relativeViewNum, relativeViewNum);
			targetDistance = targetOffset - initOffset;

			// Configure base animation properties
			this.setDuration(animationDuration);
			this.setInterpolator(mDecelerateInterpolater);

			// Start/continued animation
			isAnimationInProgres = true;
		}

		@Override
		protected void applyTransformation(float interpolatedTime,
				Transformation transformation) {
			// Ensure interpolatedTime does not over-shoot then calculate new
			// offset
			interpolatedTime = (interpolatedTime > 1.0f) ? 1.0f
					: interpolatedTime;
			int offset = initOffset + (int) (targetDistance * interpolatedTime);

			for (int ViewNum = 0; ViewNum < 3; ViewNum++) {
				// Only need to animate the visible views as the other view will
				// always be off-screen
				if ((targetDistance > 0 && ViewNum != getNextViewNum(relativeViewNum))
						|| (targetDistance < 0 && ViewNum != getPrevViewNum(relativeViewNum))) {
					flingGalleryView[ViewNum].setOffset(offset, 0,
							relativeViewNum);
				}
			}
		}

		@Override
		public boolean getTransformation(long currentTime,
				Transformation outTransformation) {
			if (super.getTransformation(currentTime, outTransformation) == false) {
				// Perform final adjustment to offsets to cleanup animation
				flingGalleryView[0].setOffset(targetOffset, 0, relativeViewNum);
				flingGalleryView[1].setOffset(targetOffset, 0, relativeViewNum);
				flingGalleryView[2].setOffset(targetOffset, 0, relativeViewNum);

				// Reached the animation target
				isAnimationInProgres = false;

				return false;
			}

			// Cancel if the screen touched
			if (isTouch || isDragging) {
				// Note that at this point we still consider ourselves to be
				// animating
				// because we have not yet reached the target offset; its just
				// that the
				// user has temporarily interrupted the animation with a touch
				// gesture

				return false;
			}

			return true;
		}
	}

	private class FlingGestureDetector extends
			GestureDetector.SimpleOnGestureListener {
		@Override
		public boolean onDown(MotionEvent e) {
			// Stop animation
			isTouch = true;

			// Reset fling state
			flingDirection = 0;
			return true;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			if (e2.getAction() == MotionEvent.ACTION_MOVE) {
				if (isDragging == false) {
					// Stop animation
					isTouch = true;

					// Reconfigure scroll
					isDragging = true;
					flingDirection = 0;
					scrollTimeStamp = System.currentTimeMillis();
					curOffset = flingGalleryView[curViewNum].getCurrentOffset();
				}

				float maxVelocity = galleryWidth
						/ (animationDuration / 1000.0f);
				long timestampDelta = System.currentTimeMillis()
						- scrollTimeStamp;
				float maxScrollDelta = maxVelocity * (timestampDelta / 1000.0f);
				float currentScrollDelta = e1.getX() - e2.getX();

				if (currentScrollDelta < maxScrollDelta * -1)
					currentScrollDelta = maxScrollDelta * -1;
				if (currentScrollDelta > maxScrollDelta)
					currentScrollDelta = maxScrollDelta;
				int scrollOffset = Math.round(curOffset + currentScrollDelta);

				// We can't scroll more than the width of our own frame layout
				if (scrollOffset >= galleryWidth)
					scrollOffset = galleryWidth;
				if (scrollOffset <= galleryWidth * -1)
					scrollOffset = galleryWidth * -1;

				flingGalleryView[0].setOffset(scrollOffset, 0, curViewNum);
				flingGalleryView[1].setOffset(scrollOffset, 0, curViewNum);
				flingGalleryView[2].setOffset(scrollOffset, 0, curViewNum);
			}

			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (Math.abs(e1.getY() - e2.getY()) <= swipe_max_off_path) {
				if (e2.getX() - e1.getX() > swipe_min_distance
						&& Math.abs(velocityX) > swipe_threshold_veloicty) {
					movePrevious();
				}

				if (e1.getX() - e2.getX() > swipe_min_distance
						&& Math.abs(velocityX) > swipe_threshold_veloicty) {
					moveNext();
				}
			}

			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// Finalise scrolling
			flingDirection = 0;
			processGesture();
		}

		@Override
		public void onShowPress(MotionEvent e) {
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// Reset fling state
			flingDirection = 0;
			return false;
		}
	}

	private class FlingGalleryView {
		private int viewNum;
		private FrameLayout parentLayout;

		private FrameLayout invalidLayout = null;
		private LinearLayout internalLayout = null;
		private View externalView = null;
		private LayoutParams FF = new LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);

		public FlingGalleryView(int ViewNum, FrameLayout parentLayout) {
			viewNum = ViewNum;
			this.parentLayout = parentLayout;

			// Invalid layout is used when outside gallery
			invalidLayout = new FrameLayout(context);
			invalidLayout.setLayoutParams(FF);

			// Internal layout is permanent for duration
			internalLayout = new LinearLayout(context);
			internalLayout.setLayoutParams(FF);

			this.parentLayout.addView(internalLayout);
		}

		public void recycleView(int newPos) {
			if (externalView != null) {
				internalLayout.removeView(externalView);
			}

			if (galleryAdp != null) {
				if (newPos >= getFirstPos() && newPos <= getLastPos()) {
					// 获得视图
					externalView = galleryAdp.getView(newPos, externalView,
							internalLayout);
				} else {
					externalView = invalidLayout;
				}
			}

			if (externalView != null) {
				internalLayout.addView(externalView, FF);
			}
		}

		public void setOffset(int xOffset, int yOffset, int relativeViewNum) {
			// Scroll the target view relative to its own Pos relative to
			// currently displayed view
			internalLayout.scrollTo(getViewOffset(viewNum, relativeViewNum)
					+ xOffset, yOffset);
		}

		public int getCurrentOffset() {
			// Return the current scroll Pos
			return internalLayout.getScrollX();
		}

		public void requestFocus() {
			internalLayout.requestFocus();
		}
	}
}
