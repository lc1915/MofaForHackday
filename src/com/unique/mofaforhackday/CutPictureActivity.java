package com.unique.mofaforhackday;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class CutPictureActivity extends Activity {

	private ImageView imageView;
	private ImageButton imageButton;
	private TextView textView;
	private Bitmap bitmap0;
	static Bitmap icon;
	static int width0;
	static int height0;
	private int width;
	private int height;
	private Matrix matrix0 = new Matrix();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
		setContentView(R.layout.cutpicture_activity);

		imageButton = (ImageButton) findViewById(R.id.imageButton1);
		imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setOnTouchListener(new TouchListener());
		textView=(TextView)findViewById(R.id.textView1);
		textView.setTextColor(Color.WHITE);
		textView.setShadowLayer(10, 0, 4, R.color.myColor);
		
		bitmap0 = ViewpagerActivity.bitmap;
		icon = ViewpagerActivity.bitmap;
		
		// 图片居中显示
		width = getWindowManager().getDefaultDisplay().getWidth() / 2
				- bitmap0.getWidth() / 2;
		height = getWindowManager().getDefaultDisplay().getHeight() / 2
				- bitmap0.getHeight() / 2;
		Matrix matrix = new Matrix();
		matrix.postTranslate(width, height);
		imageView.setImageMatrix(matrix);
		matrix0.set(imageView.getImageMatrix());

		width0 = getWindowManager().getDefaultDisplay().getWidth();
		height0 = getWindowManager().getDefaultDisplay().getHeight();
		Log.e("aaa",
				"屏幕宽度" + width0 + " 屏幕高度" + height0 + " 图片宽度"
						+ bitmap0.getWidth() + " 图片高度" + bitmap0.getHeight());

		imageView.setImageBitmap(bitmap0);
		imageView.setDrawingCacheEnabled(true);

		// 监听 保存button2
		imageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// imageView.setScaleType(ScaleType.CENTER_CROP);

				icon = Bitmap.createBitmap(imageView.getDrawingCache());
				imageView.setDrawingCacheEnabled(false);

				int width = icon.getWidth();
				int height = icon.getHeight();
				System.out.println("icon宽" + width + "高" + height);

				Intent intent = new Intent();
				intent.setClass(CutPictureActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}

	private final class TouchListener implements OnTouchListener {
		/** 记录是拖拉照片模式还是放大缩小照片模式 */
		private int mode = 0;// 初始状态
		/** 拖拉照片模式 */
		private static final int MODE_DRAG = 1;
		/** 放大缩小照片模式 */
		private static final int MODE_ZOOM = 2;
		/** 用于记录开始时候的坐标位置 */
		private PointF startPoint = new PointF();
		/** 用于记录拖拉图片移动的坐标位置 */
		private Matrix matrix = new Matrix();

		/** 用于记录图片要进行拖拉时候的坐标位置 */
		private Matrix currentMatrix = new Matrix();
		/** 两个手指的开始距离 */
		private float startDis;
		/** 两个手指的中间点 */
		private PointF midPoint;

		@Override
		public boolean onTouch(View v, MotionEvent event) {

			/** 通过与运算保留最后八位 MotionEvent.ACTION_MASK = 255 */
			switch (event.getAction() & MotionEvent.ACTION_MASK) { // 手指压下屏幕
			case MotionEvent.ACTION_DOWN:
				mode = MODE_DRAG; // 记录ImageView当前的移动位置
				currentMatrix.set(imageView.getImageMatrix());
				startPoint.set(event.getX(), event.getY());
				break; // 手指在屏幕上移动，改事件会被不断触发
			case MotionEvent.ACTION_MOVE: // 拖拉图片
				if (mode == MODE_DRAG) {
					int deltaX=(bitmap0.getWidth()-width0)/2;
					int deltaY=(bitmap0.getHeight()-height0)/2;
					float dx = event.getX() - startPoint.x; // 得到x轴的移动距离
					float dy = event.getY() - startPoint.y; // 得到x轴的移动距离 //
															// 在没有移动之前的位置上进行移动
					// if (dx < (bitmap0.getWidth() - width0) / 2
					// && dx > -(bitmap0.getWidth() - width0) / 2
					// && dy < (bitmap0.getHeight() - height0) / 2
					// && dy > -((bitmap0.getHeight() - height0) / 2)) {
					matrix.set(currentMatrix);
					matrix.postTranslate(dx, dy);
					// } else {
					// matrix.set(currentMatrix);
					// matrix.postTranslate(0, 0);
					// }
				} // 放大缩小图片
				else if (mode == MODE_ZOOM) {
					float endDis = distance(event);// 结束距离
					if (endDis > 10f) { // 两个手指并拢在一起的时候像素大于10
						float scale = endDis / startDis;// 得到缩放倍数
						matrix.set(currentMatrix);
						matrix.postScale(scale, scale, midPoint.x, midPoint.y);
					}
				}
				break; // 手指离开屏幕
			case MotionEvent.ACTION_UP: // 当触点离开屏幕，但是屏幕上还有触点(手指)
				mode = 0;
				/*
				 * float width = imageView.getScale() *
				 * imageView.getImageWidth(); float height =
				 * imageView.getScale() * imageView.getImageHeight(); if ((int)
				 * width <= CutPictureActivity.height0 && (int) height
				 * <=CutPictureActivity.height0)// 如果图片当前大小<屏幕大小，判断边界 { break; }
				 * float w[] = new float[9]; Matrix m =
				 * imageView.getImageMatrix(); m.getValues(w); float top =
				 * w[Matrix.MTRANS_Y]; float bottom = top + height; if (top > 0)
				 * { imageView.postTranslateDur(-top, 200f); } Log.i("manga",
				 * "bottom:" + bottom); if (bottom < CutPictureActivity.height0)
				 * { imageView.postTranslateDur(CutPictureActivity.height0 -
				 * bottom, 200f); }
				 */
			case MotionEvent.ACTION_POINTER_UP:
				mode = 0;
				break; // 当屏幕上已经有触点(手指)，再有一个触点压下屏幕
			case MotionEvent.ACTION_POINTER_DOWN:
				mode = MODE_ZOOM;
				/** 计算两个手指间的距离 */
				startDis = distance(event);
				/** 计算两个手指间的中间点 */
				if (startDis > 10f) { // 两个手指并拢在一起的时候像素大于10
					midPoint = mid(event); // 记录当前ImageView的缩放倍数
					currentMatrix.set(imageView.getImageMatrix());
				}
				break;
			}

			float a[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			matrix.getValues(a);
			// Log.e("bbb", a[0] + "a[0]");
			if (a[0] < 1)
				imageView.setImageMatrix(matrix0);
			else
				imageView.setImageMatrix(matrix);

			// Log.e("aaa", imageView.getImageMatrix() + "");

			return true;
		}

		/** 计算两个手指间的距离 */
		private float distance(MotionEvent event) {
			float dx = event.getX(1) - event.getX(0);
			float dy = event.getY(1) - event.getY(0);
			/** 使用勾股定理返回两点之间的距离 */
			return FloatMath.sqrt(dx * dx + dy * dy);
		}

		/** 计算两个手指间的中间点 */
		private PointF mid(MotionEvent event) {
			float midX = (event.getX(1) + event.getX(0)) / 2;
			float midY = (event.getY(1) + event.getY(0)) / 2;
			return new PointF(midX, midY);
		}
	}
}
