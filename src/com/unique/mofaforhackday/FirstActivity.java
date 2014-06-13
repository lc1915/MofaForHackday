package com.unique.mofaforhackday;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FirstActivity extends Activity {

	private ImageButton mofazhizuoButton;
	private ImageButton shareButton;
	private ImageButton aboutButton;
	private ImageView imageView;

	static Bitmap bitmap;
	private Uri selectedImage;
	ContentResolver contentResolver;
	private static int RESULT_LOAD_IMAGE = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		// this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
		setContentView(R.layout.first_activity);

		WindowManager manager = getWindowManager();
		int width = manager.getDefaultDisplay().getWidth();
		int height = manager.getDefaultDisplay().getHeight();

		mofazhizuoButton = (ImageButton) findViewById(R.id.imageButton_mofazhizuo);
		shareButton = (ImageButton) findViewById(R.id.imageButton_share);
		aboutButton = (ImageButton) findViewById(R.id.imageButton_about);
		imageView = (ImageView) findViewById(R.id.imageView1);

		/*
		 * imageView.setDrawingCacheEnabled(true); Bitmap icon =
		 * Bitmap.createBitmap(imageView.getDrawingCache());
		 * imageView.setDrawingCacheEnabled(false);
		 * 
		 * RelativeLayout
		 * relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayout);
		 * relativeLayout.removeView(imageView);
		 * 
		 * MarginLayoutParams mp = new
		 * MarginLayoutParams(icon.getWidth(),icon.getHeight()); //item的宽高
		 * mp.setMargins(0, 0, 0, (int)(height*0.5));//分别是margin_top那四个属性
		 * RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(mp);
		 * lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		 * lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		 * imageView.setLayoutParams(lp); relativeLayout.addView(imageView);
		 */

		contentResolver = this.getContentResolver();
		mofazhizuoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

				startActivityForResult(intent, RESULT_LOAD_IMAGE);
			}
		});

		aboutButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(FirstActivity.this, ViewpagerActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
				finish();
			}
		});

		shareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, "我在使用模法处理图片~你也来试试吧！");
				sendIntent.setType("text/plain");
				startActivity(sendIntent);
			}
		});
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			selectedImage = data.getData();

			// 压缩图片 避免出现OOM
			try {
				Display display = getWindowManager().getDefaultDisplay();
				DisplayMetrics displayMetrics = getResources()
						.getDisplayMetrics();

				int x = displayMetrics.widthPixels;
				int y = displayMetrics.heightPixels;

				Bitmap bitmap0 = BitmapFactory.decodeStream(contentResolver
						.openInputStream(selectedImage));

				int width = bitmap0.getWidth();
				int height = bitmap0.getHeight();
				int newWidth = x;
				int newHeight = y;

				float scaleWidth = ((float) newWidth) / width;
				float scaleHeight = ((float) newHeight) / height;

				if (width / newWidth < height / newHeight) {
					scaleHeight = scaleWidth;
				} else {
					scaleWidth = scaleHeight;
				}

				Matrix matrix = new Matrix();
				matrix.postScale(scaleWidth, scaleHeight);
				// create the new Bitmap object
				bitmap = Bitmap.createBitmap(bitmap0, 0, 0, width, height,
						matrix, true);

			} catch (FileNotFoundException e) {

			}

			Intent intent = new Intent();
			intent.setClass(FirstActivity.this, CutPictureActivity.class);
			startActivity(intent);
			finish();
		}

	}

}
