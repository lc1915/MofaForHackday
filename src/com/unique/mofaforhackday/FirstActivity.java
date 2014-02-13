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
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class FirstActivity extends Activity {

	private ImageButton mofazhizuoButton;
	private ImageButton shareButton;
	private ImageButton aboutButton;

	static Bitmap bitmap;
	private Uri selectedImage;
	ContentResolver contentResolver;
	private static int RESULT_LOAD_IMAGE = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		setContentView(R.layout.first_activity);

		mofazhizuoButton = (ImageButton) findViewById(R.id.imageButton_mofazhizuo);
		shareButton = (ImageButton) findViewById(R.id.imageButton_share);
		aboutButton = (ImageButton) findViewById(R.id.imageButton_about);

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
				intent.setClass(FirstActivity.this, AboutActivity.class);
				startActivity(intent);
			}
		});

		shareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent sendIntent = new Intent();  
				sendIntent.setAction(Intent.ACTION_SEND);  
				sendIntent.putExtra(Intent.EXTRA_TEXT, "我在使用模法处理图片哦~你也来试试吧！");  
				sendIntent.setType("text/plain");  
				startActivity(sendIntent);  
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			selectedImage = data.getData();

			try {
				bitmap = BitmapFactory.decodeStream(contentResolver
						.openInputStream(selectedImage));
			} catch (FileNotFoundException e) {
				Log.e("Exception", e.getMessage(), e);
			}

			Intent intent = new Intent();
			intent.setClass(FirstActivity.this, MainActivity.class);
			startActivity(intent);
			// finish();
		}

	}

}
