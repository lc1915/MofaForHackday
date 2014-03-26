package com.unique.mofaforhackday;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.unique.mofaforhackday.MainActivity.AsyncTaskThread;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class OkActivity extends Activity {

	private ImageView myImageView;
	private ImageButton wallpaperButton;
	private ImageButton homeButton;
	private ImageButton shareButton;

	Bitmap bitmap;
	WallpaperManager wallpaperManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
		setContentView(R.layout.ok_activity);

		myImageView = (ImageView) findViewById(R.id.imageView1);
		wallpaperButton = (ImageButton) findViewById(R.id.imageButton_wallpaper);
		homeButton = (ImageButton) findViewById(R.id.imageButton_home);
		shareButton = (ImageButton) findViewById(R.id.imageButton_share);

		if (MainActivity.icon != null)
			bitmap = MainActivity.icon;
		else
			bitmap = MainActivity.newBitmap;
		myImageView.setImageBitmap(bitmap);
		wallpaperManager = WallpaperManager.getInstance(this);

		new Thread() {
			public void run() {
				if (MainActivity.icon != null)
					saveMyBitmap(MainActivity.icon, MainActivity.icon + "");
				else
					saveMyBitmap(MainActivity.newBitmap, MainActivity.newBitmap
							+ "");
			};
		}.start();

		// 监听 设为壁纸button
		wallpaperButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					wallpaperManager.setBitmap(bitmap);
					Toast.makeText(getApplicationContext(), "壁纸设置成功",
							Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		// 监听 回到主页button
		homeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(OkActivity.this, FirstActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// 监听 分享button
		shareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent shareIntent = new Intent(Intent.ACTION_SEND);
				File file = new File("/sdcard/" + bitmap + ".png");
				shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
				shareIntent.setType("image/jpeg");
				startActivity(Intent.createChooser(shareIntent, getTitle()));
			}
		});

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
	}

	// 异步更新
	class AsyncTaskThread extends AsyncTask<String, Integer, Bitmap> {

		protected void doInBackground(Bitmap bitmap, String bitName) {

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

		}

		protected void onProgressUpdate(Integer... progress) {

		}

		protected void onPostExecute(Bitmap result) {

		}

		protected void onPreExecute() {

		}

		protected void onCancelled() {

		}

		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
