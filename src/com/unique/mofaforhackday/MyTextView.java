package com.unique.mofaforhackday;

import android.R.integer;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

class MyTextView extends TextView {
	private int mPreviousx = 0;
	private int mPreviousy = 0;
	static int l;
	static int t;
	static int r;
	static int b;

	public MyTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	// On touch Event.
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		final int iAction = event.getAction();
		final int iCurrentx = (int) event.getX();
		final int iCurrenty = (int) event.getY();
		//Log.e("0", iCurrentx + " " + iCurrenty);
		switch (iAction) {
		case MotionEvent.ACTION_DOWN:
			mPreviousx = iCurrentx;
			mPreviousy = iCurrenty;
			break;
		case MotionEvent.ACTION_MOVE:
			int iDeltx = iCurrentx - mPreviousx;
			int iDelty = iCurrenty - mPreviousy;

			final int iLeft = getLeft();
			final int iTop = getTop();
			if (iDeltx != 0 || iDelty != 0) {
				layout(iLeft + iDeltx, iTop + iDelty, iLeft + iDeltx
						+ getWidth(), iTop + iDelty + getHeight());
				l = iLeft + iDeltx;
				t = iTop + iDelty;
				r = iLeft + iDeltx + getWidth();
				b = iTop + iDelty + getHeight();
				Log.e("aaa", l+" "+t+" "+r+" "+b);
			}

			break;
		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_CANCEL:
			break;
		}
		return true;
	}
}