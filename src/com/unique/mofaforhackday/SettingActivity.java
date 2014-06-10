package com.unique.mofaforhackday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class SettingActivity extends Activity implements OnTouchListener,
		OnGestureListener {
	
	GestureDetector mGestureDetector;

	private Button aboutButton;
	private Button adviceButton;
	private Button checkButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		//		WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
		setContentView(R.layout.setting_activity);
		
		mGestureDetector = new GestureDetector((OnGestureListener) this);
		RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.relativelayout000);
		relativeLayout.setOnTouchListener(this);
		relativeLayout.setLongClickable(true);

		aboutButton = (Button) findViewById(R.id.button1);
		adviceButton = (Button) findViewById(R.id.button2);
		checkButton = (Button) findViewById(R.id.button3);

		aboutButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SettingActivity.this, AboutActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
				finish();
			}
		});
		
		checkButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		if (e1.getX() - e2.getX() > snsConstant.getFlingMinDistance()
				&& Math.abs(velocityX) > snsConstant.getFlingMinVelocity()) {

			// 切换Activity
			//Intent intent = new Intent(AboutActivity.this,
			//		UpdateStatusActivity.class);
			//startActivity(intent);
			//overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
			//Toast.makeText(this, "向左手势", Toast.LENGTH_SHORT).show();
		} else if (e2.getX() - e1.getX() > snsConstant.getFlingMinDistance()
				&& Math.abs(velocityX) > snsConstant.getFlingMinVelocity()) {

			/*Intent intent = new Intent(SettingActivity.this,
					FirstActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
			//Toast.makeText(this, "向右手势", Toast.LENGTH_SHORT).show();
			finish();*/
		}
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);
	}
}