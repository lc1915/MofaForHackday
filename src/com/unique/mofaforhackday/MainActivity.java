package com.unique.mofaforhackday;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView myImageView;
	private SeekBar seekBar;
	private ImageButton saveButton;
	private ImageButton wordButton;
	private EditText editText;
	int progress0;

	private Uri selectedImage;// 从sd卡中获取的图片的uri
	private static int RESULT_LOAD_IMAGE = 0;// onActivityResult中requestCode的值
	static Bitmap bitmap0;
	static Bitmap newBitmap;
	static Bitmap icon;
	WallpaperManager wallpaperManager;
	float startX;// touch的起始x
	float startY;// touch的起始y
	String str1;// editText中的字符串
	String fontString;

	private StackBlurManager stackBlurManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		setContentView(R.layout.activity_main);

		myImageView = (ImageView) findViewById(R.id.imageView1);
		myImageView.setOnTouchListener(touch);// 使图片可触摸
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		editText = (EditText) findViewById(R.id.editText1);
		saveButton = (ImageButton) findViewById(R.id.imageButton_ok);
		wordButton = (ImageButton) findViewById(R.id.imageButton_word);

		bitmap0 = FirstActivity.bitmap;
		newBitmap = FirstActivity.bitmap;
		myImageView.setImageBitmap(bitmap0);
		stackBlurManager = new StackBlurManager(bitmap0);

		wallpaperManager = WallpaperManager.getInstance(this);
		fontString = "font/yahei.ttf";
		str1 = "";

		final Context context = this;

		// 监听 拖动条
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

				AsyncTaskThread thread = new AsyncTaskThread();
				thread.doInBackground(bitmap0);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progress0 = progress;

			}
		});

		// 监听 保存button
		saveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (icon != null)
					saveMyBitmap(icon, icon + "");
				saveMyBitmap(newBitmap, newBitmap + "");

				Intent intent = new Intent();
				intent.setClass(MainActivity.this, OkActivity.class);
				startActivity(intent);
				finish();
			}
		});

		wordButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

	}

	// 异步更新
	class AsyncTaskThread extends AsyncTask<String, Integer, Bitmap> {

		protected Bitmap doInBackground(Bitmap bitmap) {
			Log.e("asd", "asdf");
			// 改变模糊上限
			stackBlurManager.process(progress0 * 2);
			myImageView.setImageBitmap(stackBlurManager.returnBlurredImage());
			newBitmap = stackBlurManager.returnBlurredImage();
			return newBitmap;
		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(Bitmap result) {
			if (result != null) {
				Toast.makeText(MainActivity.this, "成功获取图片", Toast.LENGTH_LONG)
						.show();
				myImageView.setImageBitmap(result);
			} else {
				Toast.makeText(MainActivity.this, "获取图片失败", Toast.LENGTH_LONG)
						.show();
			}
		}

		protected void onPreExecute() {
			myImageView.setImageBitmap(null);

		}

		protected void onCancelled() {

		}

		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	// 图片上加文字
	private void drawNewBitmap(ImageView imageView, String str) {
		Bitmap photo = newBitmap;

		int width = photo.getWidth();
		int height = photo.getHeight();
		System.out.println("宽" + width + "高" + height);

		icon = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); // 建立一个空的BItMap
		Canvas canvas = new Canvas(icon);// 初始化画布绘制的图像到icon上

		Paint photoPaint = new Paint(); // 建立画笔
		photoPaint.setDither(true); // 获取跟清晰的图像采样
		photoPaint.setFilterBitmap(true);// 过滤一些

		Rect src = new Rect(0, 0, photo.getWidth(), photo.getHeight());// 创建一个指定的新矩形的坐标
		Rect dst = new Rect(0, 0, width, height);// 创建一个指定的新矩形的坐标
		canvas.drawBitmap(photo, src, dst, photoPaint);// 将photo
														// 缩放或则扩大到dst使用的填充区photoPaint

		Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG
				| Paint.DEV_KERN_TEXT_FLAG);// 设置画笔
		textPaint.setTextAlign(Paint.Align.CENTER);// 中心
		textPaint.setShadowLayer(10, 10, 10, Color.GRAY);// 设置阴影
		textPaint.setTextSize(80.0f);// 字体大小

		// 设置自带字体
		// AssetManager assetManager = getApplicationContext().getAssets();
		// Log.e("ziti", fontString);
		// Typeface typeFace = Typeface.createFromAsset(assetManager,
		// fontString);
		// textPaint.setTypeface(typeFace);

		textPaint.setColor(Color.BLACK);// 采用的颜色
		// textPaint.setAlpha(30);// 设置透明度

		if (startX == 0 && startY == 0)
			canvas.drawText(str, bitmap0.getWidth() / 2,
					bitmap0.getHeight() / 2, textPaint);
		canvas.drawText(str, startX, startY, textPaint);
		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
		imageView.setImageBitmap(icon);

	}

	private View.OnTouchListener touch = new OnTouchListener() {

		Canvas canvas;
		Paint paint;
		Bitmap icon0;

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			paint = new Paint();
			paint.setStrokeWidth(5);
			paint.setColor(Color.BLACK);

			switch (event.getAction()) {
			// 用户按下动作
			case MotionEvent.ACTION_DOWN:
				Bitmap photo;
				str1 = "";
				str1 = editText.getText().toString();
				drawNewBitmap(myImageView, str1);
				// 第一次绘图初始化内存图片，指定背景为白色
				if (icon == null)
					photo = newBitmap;
				photo = icon;

				int width = photo.getWidth();
				int height = photo.getHeight();
				System.out.println("宽" + width + "高" + height);

				icon0 = Bitmap.createBitmap(width, height,
						Bitmap.Config.ARGB_8888); // 建立一个空的Bitmap
				canvas = new Canvas(icon0);// 初始化画布绘制的图像到icon上
				Paint photoPaint = new Paint(); // 建立画笔
				photoPaint.setDither(true); // 获取跟清晰的图像采样
				photoPaint.setFilterBitmap(true);// 过滤一些
				Rect src = new Rect(0, 0, photo.getWidth(), photo.getHeight());// 创建一个指定的新矩形的坐标
				Rect dst = new Rect(0, 0, width, height);// 创建一个指定的新矩形的坐标
				canvas.drawBitmap(photo, src, dst, photoPaint);

				// 记录开始触摸的点的坐标
				startX = event.getX();
				Log.e("startx", startX + "");
				startY = event.getY();
				Log.e("starty", startY + "");

				float x = 360;
				float y = 540;
				if (width > 720 && height > 1080) {
					x = width / 2 - 360 + startX;
					y = height / 2 - 540 + startY;
				} else if (width > 720 && height < 1080) {
					int k = 1080 / height;
					width = k * width;
					height = 1080;
					x = width / 2 - 360 + startX;
					y = startY;
				} else if (width < 720 && height > 1080) {
					int k = 720 / width;
					height = height * k;
					x = startX * k;
					y = height / 2 - 540 + startY;
				} else if (720 / width >= 1080 / height) {
					int k = 720 / width;
					x = startX * k;
					y = startY * k;
				} else if (720 / width < 1080 / height) {
					int k = 1080 / height;
					x = startX * k;
					y = startY * k;
				}

				startX = x;
				startY = y;
				drawNewBitmap(myImageView, str1);
				break;
			// 用户手指在屏幕上移动的动作
			case MotionEvent.ACTION_MOVE:
				// 记录移动位置的点的坐标
				float stopX = event.getX();
				float stopY = event.getY();

				// 根据两点坐标，绘制连线
				// canvas.drawLine(startX, startY, stopX, stopY, paint);

				// 更新开始点的位置
				startX = event.getX();
				startY = event.getY();

				// 把图片展示到ImageView中
				myImageView.setImageBitmap(icon0);
				break;
			case MotionEvent.ACTION_UP:

				break;
			default:
				break;
			}
			return true;
		}
	};

	// 读取asset中的图片（未使用）
	private Bitmap getBitmapFromAsset(Context context, String strName) {
		Log.e("a", "first");
		AssetManager assetManager = context.getAssets();
		InputStream istr;
		Bitmap bitmap = null;
		try {
			istr = assetManager.open(strName);
			bitmap = BitmapFactory.decodeStream(istr);
		} catch (IOException e) {
			return null;
		}
		return bitmap;
	}

	// 保存到SD卡
	public void saveMyBitmap(Bitmap bitmap, String bitName) {
		File f = new File("/sdcard/" + bitName + ".png");

		FileOutputStream fOut = null;
		try {
			f.createNewFile();
			fOut = new FileOutputStream(f);
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
			fOut.flush();
			fOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Toast.makeText(getApplicationContext(),
				"成功保存到" + "/sdcard/" + bitName + ".png", Toast.LENGTH_LONG)
				.show();
	}

}