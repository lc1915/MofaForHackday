package com.unique.mofaforhackday;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ViewpagerActivity extends Activity implements
		OnPageChangeListener, OnTouchListener, OnGestureListener {

	static ViewPager vp;
	private ViewPagerAdapter vpAdapter;
	private List<View> views;
	GestureDetector mGestureDetector;

	private ImageButton mofazhizuoButton;
	private ImageButton fankuiButton;
	private ImageButton aboutButton;
	private ImageView imageView;

	View view0;

	private RelativeLayout relativeLayout;

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
		setContentView(R.layout.guide);

		// 初始化页面
		initViews();

		// mGestureDetector = new GestureDetector((OnGestureListener) this);

		/*
		 * ViewPager relativeLayout111 = (ViewPager)
		 * findViewById(R.id.viewpager);
		 * relativeLayout111.setOnTouchListener(this);
		 * relativeLayout111.setLongClickable(true);
		 */

		view0 = views.get(0);

		WindowManager manager = getWindowManager();
		int width = manager.getDefaultDisplay().getWidth();
		int height = manager.getDefaultDisplay().getHeight();

		mofazhizuoButton = (ImageButton) view0
				.findViewById(R.id.imageButton_mofazhizuo);
		fankuiButton = (ImageButton) view0.findViewById(R.id.imageButton_share);
		aboutButton = (ImageButton) view0.findViewById(R.id.imageButton_about);
		imageView = (ImageView) view0.findViewById(R.id.imageView1);
		relativeLayout = (RelativeLayout) view0
				.findViewById(R.id.relativeLayout);

		AnimationSet animationSet = new AnimationSet(false);
		TranslateAnimation translateAnimation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 4f, Animation.RELATIVE_TO_SELF, -0f);
		translateAnimation.setInterpolator(new OvershootInterpolator(0.7f));
		animationSet.addAnimation(translateAnimation);
		animationSet.setDuration(550);
		animationSet.setStartOffset(5);// 执行前停留的时间（毫秒）
		animationSet.setFillAfter(true);// 如果为true，执行完动画后，停留到执行开始的时候

		LayoutAnimationController laController = new LayoutAnimationController(
				animationSet);
		laController.setOrder(LayoutAnimationController.ORDER_NORMAL);
		relativeLayout.setLayoutAnimation(laController);

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
				ViewpagerActivity.vp.setCurrentItem(1);
			}
		});

		fankuiButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(ViewpagerActivity.this, FankuiActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right); 
			}
		});

		View view1 = views.get(1);

		Button aboutButton = (Button) view1.findViewById(R.id.button1);
		aboutButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ViewpagerActivity.vp.setCurrentItem(2);
			}
		});

		Button shareButton = (Button) view1.findViewById(R.id.button2);
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

		/*
		 * RelativeLayout relativeLayout1 = (RelativeLayout) view0
		 * .findViewById(R.id.first_relativelayout);
		 * relativeLayout1.setOnTouchListener(this);
		 * relativeLayout1.setLongClickable(true);
		 */
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
				Log.i("view", "height:" + display.getHeight());
				Log.i("view", "width:" + display.getWidth());
				DisplayMetrics displayMetrics = getResources()
						.getDisplayMetrics();
				Log.i("view", "height" + displayMetrics.heightPixels);
				Log.i("view", "width" + displayMetrics.widthPixels);

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
				Log.e("Exception", e.getMessage(), e);
			}

			Intent intent = new Intent();
			intent.setClass(ViewpagerActivity.this, CutPictureActivity.class);
			startActivity(intent);
			// finish();
		}

	}

	private void initViews() {
		LayoutInflater inflater = LayoutInflater.from(this);

		views = new ArrayList<View>();
		// 初始化引导图片列表
		views.add(inflater.inflate(R.layout.first_activity, null));
		views.add(inflater.inflate(R.layout.setting_activity, null));
		views.add(inflater.inflate(R.layout.about_activity, null));
		// views.add(inflater.inflate(R.layout.guide_view3, null));
		// views.add(inflater.inflate(R.layout.guide_view0, null));

		// 初始化Adapter
		vpAdapter = new ViewPagerAdapter(views, this);

		vp = (ViewPager) findViewById(R.id.viewpager);
		vp.setAdapter(vpAdapter);

		// 绑定回调
		vp.setOnPageChangeListener(this);

	}

	// 当滑动状态改变时调用
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	// 当当前页面被滑动时调用
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	// 当新的页面被选中时调用
	@Override
	public void onPageSelected(int arg0) {

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
			// Intent intent = new Intent(AboutActivity.this,
			// UpdateStatusActivity.class);
			// startActivity(intent);
			// overridePendingTransition(R.anim.in_from_right,
			// R.anim.out_to_left);
			// Toast.makeText(this, "向左手势", Toast.LENGTH_SHORT).show();
		} else if (e2.getX() - e1.getX() > snsConstant.getFlingMinDistance()
				&& Math.abs(velocityX) > snsConstant.getFlingMinVelocity()) {

			Intent intent = new Intent(ViewpagerActivity.this,
					FankuiActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
			// Toast.makeText(this, "向右手势", Toast.LENGTH_SHORT).show();
			finish();
		}
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);
	}

}
