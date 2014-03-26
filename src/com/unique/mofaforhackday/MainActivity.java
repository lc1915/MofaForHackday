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
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import android.renderscript.*;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;

public class MainActivity extends Activity {

	private int intCounter = 0;
	private boolean a = false;
	private int textSize;

	private ImageView myImageView;
	private SeekBar seekBar;
	private SeekBar textSeekBar;
	private ImageButton saveButton;
	private ImageButton saveButton2;
	private ImageButton wordButton;
	private ImageButton wordButton2;
	private ImageButton fontButton;
	private ImageButton haoButton;
	private ImageButton textsizeButton;
	private SlidingDrawer slidingDrawer;
	private EditText editText;
	int progress0;

	private RelativeLayout relativeLayout0;
	private RelativeLayout relativeLayout1;
	private RelativeLayout relativeLayout2;
	private RelativeLayout relativeLayout3;

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
	Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
		setContentView(R.layout.activity_main);

		// this.mHandleView.performClick();

		myImageView = (ImageView) findViewById(R.id.imageView1);
		myImageView.setOnTouchListener(touch);// 使图片可触摸
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		seekBar.setMax(24);
		textSeekBar=(SeekBar)findViewById(R.id.seekBar_text);
		textSeekBar.setMax(200);
		editText = (EditText) findViewById(R.id.editText1);
		saveButton = (ImageButton) findViewById(R.id.imageButton_ok);
		saveButton2 = (ImageButton) findViewById(R.id.imageButton_ok2);
		wordButton = (ImageButton) findViewById(R.id.imageButton_word);
		wordButton2 = (ImageButton) findViewById(R.id.imageButton_word2);
		fontButton = (ImageButton) findViewById(R.id.imageButton_font);
		textsizeButton=(ImageButton)findViewById(R.id.imageButton_textsize);
		haoButton = (ImageButton) findViewById(R.id.imageButton_hao);

		relativeLayout0 = (RelativeLayout) findViewById(R.id.relativeLayout0);
		relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);
		relativeLayout2 = (RelativeLayout) findViewById(R.id.relativeLayout2);
		relativeLayout3 = (RelativeLayout) findViewById(R.id.relativeLayout3);

		bitmap0 = CutPictureActivity.icon;
		newBitmap = CutPictureActivity.icon;
		icon = CutPictureActivity.icon;// 后来加的
		
		textSize=60;

		myImageView.setImageBitmap(bitmap0);
		stackBlurManager = new StackBlurManager(bitmap0);

		wallpaperManager = WallpaperManager.getInstance(this);
		fontString = "font/Brand.ttf";
		str1 = "";

		final Context context = this;

		// 监听 拖动条
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

				// stackBlurManager.process(progress0 * 2);
				// myImageView.setImageBitmap(stackBlurManager.returnBlurredImage());

				AsyncTaskThread thread = new AsyncTaskThread();
				thread.doInBackground(bitmap0);

				//mHandler.post(fadeInTask);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				//mHandler.removeCallbacks(fadeInTask);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				progress0 = progress;

				/*
				 * if (progress0 == 3 | progress0 == 6 | progress0 == 9 |
				 * progress0 == 12 | progress0 == 15 | progress0 == 18 |
				 * progress0 == 21 | progress0 == 24) {
				 * 
				 * AsyncTaskThread thread = new AsyncTaskThread();
				 * thread.doInBackground(bitmap0); }
				 */

				// Bitmap result = rsBlur(bitmap0, MainActivity.this,
				// progress+1);
				// Bitmap result1 = rsBlur(result, MainActivity.this,
				// progress+1);
				// myImageView.setImageBitmap(result1);

				// Log.e("progress", "radius=" + progress);

			}
		});
		
		textSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				textSize=progress+50;
				drawNewBitmap(myImageView, str1);
			}
		});

		// 监听 保存button
		saveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),
						"成功保存到" + "/sdcard/" + icon + ".png", Toast.LENGTH_LONG)
						.show();

				Intent intent = new Intent();
				intent.setClass(MainActivity.this, OkActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// 监听 保存button2
		saveButton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),
						"成功保存到" + "/sdcard/" + icon + ".png", Toast.LENGTH_LONG)
						.show();

				Intent intent = new Intent();
				intent.setClass(MainActivity.this, OkActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// 监听 输入文字button
		wordButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				relativeLayout0.setVisibility(View.GONE);
				relativeLayout1.setVisibility(View.VISIBLE);
				editText.setFocusable(true);

				// seekBar.setPadding(32, 0, 32, 106);// 1080p是(48, 0, 48, 106)
			}
		});

		wordButton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout0.setVisibility(View.VISIBLE);
			}
		});

		final String[] singleChoiceItems = { "Brand", "Digetrax", "方正韵动特黑简体",
				"方正综艺", "Kildor", "manteka", "Multicolore", "Meptune8", "Rose",
				"造字公房尚黑" };
		final int defaultSelectedIndex = 0;// 单选框默认值：从0开始

		fontButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * AlertDialog builder = new AlertDialog.Builder(context)
				 * .setTitle("选择字体")// 设置对话框标题
				 * .setIcon(android.R.drawable.ic_dialog_info)// 设置对话框图标
				 * .setSingleChoiceItems( singleChoiceItems,
				 * defaultSelectedIndex, new
				 * android.content.DialogInterface.OnClickListener() {
				 * 
				 * @Override public void onClick(DialogInterface dialog, int
				 * which) { // TODO Auto-generated method stub if (which == 0)
				 * fontString = "font/Brand.ttf"; else if (which == 1)
				 * fontString = "font/Digitrax.ttf"; else if (which == 2)
				 * fontString = "font/fzyundong.ttf"; else if (which == 3)
				 * fontString = "font/fzzongyi_GBK.ttf"; else if (which == 4)
				 * fontString = "font/Kildor.ttf"; else if (which == 5)
				 * fontString = "font/manteka.ttf"; else if (which == 6)
				 * fontString = "font/Multicolore.ttf"; else if (which == 7)
				 * fontString = "font/Neptune8.ttf"; else if (which == 8)
				 * fontString = "font/Rose.ttf"; else if (which == 9) fontString
				 * = "font/zaozigongfang.ttf"; } }).setPositiveButton("确定",
				 * null)// 设置对话框[肯定]按钮 .setNegativeButton("取消", null)//
				 * 设置对话框[否定]按钮 .show();
				 */

				relativeLayout1.setVisibility(View.GONE);
				relativeLayout0.setVisibility(View.GONE);
				relativeLayout2.setVisibility(View.VISIBLE);

				drawNewBitmap(myImageView, str1);
			}
		});
		
		textsizeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout0.setVisibility(View.GONE);
				relativeLayout3.setVisibility(View.VISIBLE);
				
				drawNewBitmap(myImageView, str1);
			}
		});

		haoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (icon != null)
					newBitmap = icon;
			}
		});

	}

	/* 设定ImageView的透明度渐显出来 */
	//没用
	private Runnable fadeInTask = new Runnable() {
		public void run() {
			if (a == true) {
				intCounter = intCounter + 1;
				myImageView.setAlpha(intCounter * 15);
				if (intCounter < 10) {
					mHandler.postDelayed(fadeInTask, 50);
					a = false;
				}
			}
		}
	};

	// 异步更新
	class AsyncTaskThread extends AsyncTask<String, Integer, Bitmap> {

		protected Bitmap doInBackground(Bitmap bitmap) {
			Log.e("asd", "asdf");
			// 改变模糊上限
			// stackBlurManager.process(progress0 * 2);
			// myImageView.setImageBitmap(stackBlurManager.returnBlurredImage());
			// newBitmap = stackBlurManager.returnBlurredImage();
			// return newBitmap;

			Bitmap result0 = rsBlur(bitmap0, MainActivity.this, progress0 + 1);
			Bitmap result = rsBlur(result0, MainActivity.this, progress0 + 1);
			// Bitmap result1 = rsBlur(result, MainActivity.this, progress0 +
			// 1);
			// Bitmap result2 = rsBlur(result1, MainActivity.this, progress0 +
			// 1);
			// Bitmap result3 = rsBlur(result2, MainActivity.this, progress0 +
			// 1);
			myImageView.setImageBitmap(result);
			newBitmap = result;
			icon=newBitmap;

			return newBitmap;

		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(Bitmap result) {

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

	// 模糊算法
	public static Bitmap rsBlur(Bitmap raw, Context context, int radius) {
		RenderScript rs = RenderScript.create(context);
		Allocation alloc = Allocation.createFromBitmap(rs, raw);
		ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs,
				alloc.getElement());
		blur.setRadius(radius);
		blur.setInput(alloc);

		Bitmap result = Bitmap.createBitmap(raw.getWidth(), raw.getHeight(),
				raw.getConfig());
		Allocation outAlloc = Allocation.createFromBitmap(rs, result);
		blur.forEach(outAlloc);
		outAlloc.copyTo(result);
		rs.destroy();
		alloc.destroy();
		outAlloc.destroy();
		// raw.recycle();
		return result;
	}

	// 图片上加文字
	private void drawNewBitmap(ImageView imageView, String str) {
		Bitmap photo = newBitmap;

		int width = photo.getWidth();
		int height = photo.getHeight();
		System.out.println("宽" + width + "高" + height);

		icon = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); // 建立一个空的BItMap
		// 之前改成了(720,
		// 1280,
		// Bitmap.Config.ARGB_8888)
		Canvas canvas = new Canvas(icon);// 初始化画布绘制的图像到icon上

		Paint photoPaint = new Paint(); // 建立画笔
		photoPaint.setDither(true); // 获取跟清晰的图像采样
		photoPaint.setFilterBitmap(true);// 过滤一些

		Rect src = new Rect(0, 0, photo.getWidth(), photo.getHeight());// 创建一个指定的新矩形的坐标
		Rect dst = new Rect(0, 0, width, height);// 创建一个指定的新矩形的坐标 之前改成了(0, 0,
													// 720,
													// 1280)，图片变形
		canvas.drawBitmap(photo, src, dst, photoPaint);// 将photo
														// 缩放或则扩大到dst使用的填充区photoPaint

		Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG
				| Paint.DEV_KERN_TEXT_FLAG);// 设置画笔
		textPaint.setTextAlign(Paint.Align.CENTER);// 中心
		textPaint.setShadowLayer(10, 0, 6, R.color.myColor);// 设置阴影
		textPaint.setTextSize(textSize);// 字体大小

		// 设置自带字体
		AssetManager assetManager = getApplicationContext().getAssets();
		Log.e("ziti", fontString);
		Typeface typeFace = Typeface.createFromAsset(assetManager, fontString);
		textPaint.setTypeface(typeFace);

		textPaint.setColor(Color.WHITE);// 采用的颜色
		// textPaint.setAlpha(64);// 设置透明度

		if (startX == 0 && startY == 0)
			canvas.drawText(str, bitmap0.getWidth() / 2,
					bitmap0.getHeight() / 2, textPaint);
		canvas.drawText(str, startX, startY + 100, textPaint);
		canvas.save(Canvas.ALL_SAVE_FLAG);
		canvas.restore();
		imageView.setImageBitmap(icon);

	}

	private View.OnTouchListener touch = new OnTouchListener() {

		Canvas canvas;
		Bitmap icon0;

		@Override
		public boolean onTouch(View v, MotionEvent event) {
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

				/*
				 * float x = 360; float y = 540; if (width > 720 && height >
				 * 1080) { x = width / 2 - 360 + startX; y = height / 2 - 540 +
				 * startY; } else if (width > 720 && height < 1080) { int k =
				 * 1080 / height; width = k * width; height = 1080; x = width /
				 * 2 - 360 + startX; y = startY; } else if (width < 720 &&
				 * height > 1080) { int k = 720 / width; height = height * k; x
				 * = startX * k; y = height / 2 - 540 + startY; } else if (720 /
				 * width >= 1080 / height) { int k = 720 / width; x = startX *
				 * k; y = startY * k; } else if (720 / width < 1080 / height) {
				 * int k = 1080 / height; x = startX * k; y = startY * k; }
				 * 
				 * startX = x; startY = y;
				 */
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
			bitmap.compress(Bitmap.CompressFormat.PNG, 1, fOut);// 把100调低
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