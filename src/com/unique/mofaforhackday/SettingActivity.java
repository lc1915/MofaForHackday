package com.unique.mofaforhackday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class SettingActivity extends Activity {

	private Button aboutButton;
	private Button adviceButton;
	private Button checkButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		setContentView(R.layout.setting_activity);

		aboutButton = (Button) findViewById(R.id.button1);
		adviceButton=(Button)findViewById(R.id.button2);
		checkButton=(Button)findViewById(R.id.button3);

		aboutButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SettingActivity.this, AboutActivity.class);
				startActivity(intent);
				//finish();
			}
		});

	}
}