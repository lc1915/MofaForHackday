package com.unique.mofaforhackday;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.R.color;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.ToggleButton;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Switch;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import android.renderscript.*;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class MainActivity extends Activity {

	private int intCounter = 0;// 设置imageview渐渐显示出来的一个参数，目前没有用
	private boolean a = false;
	private int textSize;
	private boolean gray = false;

	private RelativeLayout mainLayout;
	private MyTextView textView;
	private RelativeLayout.LayoutParams rl;

	RelativeLayout layout;

	private ImageButton mohuButton;
	private ImageButton wenziButton;
	private ImageButton quseButton;

	private ImageView myImageView;
	private SeekBar seekBar;
	private SeekBar textSeekBar;
	private SeekBar tmdSeekBar;
	private ImageButton saveButton;
	private ImageButton quxiaoButton;
	private ImageButton fontButton;
	private ImageButton colorButton;
	private ImageButton shadowButton;
	private ImageButton addtextButton;
	private ImageButton addtextButton1;
	private ImageButton addtextButton2;
	private ImageButton addtextButton3;
	private ImageButton addtextButton4;
	private ImageButton haoButton;
	private ImageButton haoButton1;
	private ImageButton haoButton2;
	private ImageButton haoButton3;
	private ImageButton haoButton4;
	private ImageButton textsizeButton;
	private WrapSlidingDrawer wrapSlidingDrawer;
	private EditText editText;
	private EditText editText1;
	private EditText editText2;
	private EditText editText3;
	private EditText editText4;
	int progress0;
	private ImageButton handleSelector;

	private ImageButton tmdButton;
	private ImageButton tmdInFontButton;

	private ImageButton fontInShadowButton;
	private ImageButton textsizeInShadowButton;
	private ImageButton colorInShadowButton;

	private ImageButton shadowInFontButton;
	private ImageButton textsizeInFontButton;
	private ImageButton colorInFontButton;
	private ImageButton fontInFontButton;

	private ImageButton shadowInTextsizeButton;
	private ImageButton colorInTextsizeButton;
	private ImageButton fontInTextsizeButton;

	private ImageButton shadowInColorButton;
	private ImageButton textsizeInColorButton;
	private ImageButton fontInColorButton;

	private ToggleButton switch1;
	private ToggleButton switch_font;
	private ToggleButton switch_quse;

	private Button color1Button;
	private Button color2Button;
	private Button color3Button;
	private Button color4Button;
	private Button color5Button;
	private Button color6Button;
	private Button color7Button;
	private Button color8Button;
	private Button color9Button;
	private Button color10Button;
	private Button color11Button;
	private Button color12Button;
	private Button color13Button;
	private Button color14Button;
	private Button color15Button;
	private Button color16Button;
	private Button color17Button;
	private Button color18Button;
	private Button color19Button;
	private Button color20Button;
	private Button color21Button;
	private Button color22Button;
	private Button color23Button;
	private Button color24Button;
	private Button color25Button;
	private Button color26Button;
	private Button color27Button;
	private Button color28Button;
	private Button color29Button;
	private Button color30Button;
	private Button color31Button;
	private Button color32Button;
	private Button color33Button;
	private Button color34Button;
	private Button color35Button;

	private ImageButton font01Button;
	private ImageButton font02Button;
	private ImageButton font03Button;
	private ImageButton font04Button;
	private ImageButton font05Button;
	private ImageButton font06Button;
	private ImageButton font07Button;
	private ImageButton font08Button;
	private ImageButton font09Button;
	private ImageButton font10Button;
	private ImageButton font11Button;
	private ImageButton font12Button;
	private ImageButton font13Button;
	private ImageButton font14Button;
	private ImageButton font15Button;
	private ImageButton font16Button;
	private ImageButton font17Button;
	private ImageButton font18Button;
	private ImageButton font19Button;
	private ImageButton font20Button;
	private ImageButton font21Button;
	private ImageButton font22Button;
	private ImageButton font23Button;
	private ImageButton font24Button;
	private ImageButton font25Button;
	private ImageButton font26Button;
	private ImageButton font27Button;
	private ImageButton font28Button;
	private ImageButton font29Button;
	private ImageButton font30Button;

	private ImageButton morenButton;
	private ImageButton miaowuButton;
	private ImageButton daofengButton;
	private ImageButton shangheiButton;
	private ImageButton yueheiButton;

	private RelativeLayout relativeLayout01;
	private RelativeLayout relativeLayout1;
	private RelativeLayout relativeLayoutmore;
	private RelativeLayout relativeLayoutFont;
	private RelativeLayout relativeLayoutTextsize;
	private RelativeLayout relativeLayoutTmd;
	private HorizontalScrollView relativeLayoutColor;
	private RelativeLayout relativeLayoutShadow;
	private RelativeLayout relativeLayoutQuse;

	private HorizontalScrollView horizontalScrollView1;
	private HorizontalScrollView horizontalScrollView2;

	private Uri selectedImage;// 从sd卡中获取的图片的uri
	private static int RESULT_LOAD_IMAGE = 0;// onActivityResult中requestCode的值
	private Bitmap firstBitmap;
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

	Dialog dialog;
	Dialog dialog0;
	SharedPreferences sharedPreferences0;

	static boolean first_main = true;
	private boolean first = true;
	static boolean first0 = true;
	private boolean first_click = true;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
		setContentView(R.layout.activity_main);

		// this.mHandleView.performClick();//本来打算让handle开始为点击状态

		mainLayout = (RelativeLayout) findViewById(R.id.main);
		// textView = (MyTextView) findViewById(R.id.textView_touch);
		textView = new MyTextView(this);
		rl = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		rl.setMargins(getWindowManager().getDefaultDisplay().getWidth() / 2,
				getWindowManager().getDefaultDisplay().getHeight() / 2, 0, 0);
		textView.setLayoutParams(rl);
		mainLayout.addView(textView);

		findViewById();

		dialog0 = new Dialog(this, R.style.mydialog);// 自定义dialog全屏style

		// sharedpreferences判断
		sharedPreferences0 = this.getSharedPreferences("share", MODE_PRIVATE);
		Editor editor0 = sharedPreferences0.edit();

		if (CutPictureActivity.signal == 1 && first_main == true
				&& first == true) {
			editor0.putBoolean("isFirstRun", false);
			editor0.commit();

			first_main = false;
			first = false;

			// 首次启动应用 显示用户指导dialog
			dialog = new Dialog(this, R.style.mydialog);// 自定义dialog全屏style
			dialog.setContentView(R.layout.dialog_layout1);
			RelativeLayout dialogLayout = (RelativeLayout) dialog
					.findViewById(R.id.dialog);
			dialogLayout.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			dialog.show();
		} else {
		}

		wrapSlidingDrawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {
			@SuppressLint("NewApi")
			@Override
			public void onDrawerOpened() {
				// TODO Auto-generated method stub
				handleSelector.setBackground(getResources().getDrawable(
						R.drawable.mofa_down_down));
			}
		});

		wrapSlidingDrawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {
			@SuppressLint("NewApi")
			@Override
			public void onDrawerClosed() {
				// TODO Auto-generated method stub
				handleSelector.setBackground(getResources().getDrawable(
						R.drawable.mofa_up_down));
			}
		});

		firstBitmap = CutPictureActivity.icon;
		bitmap0 = CutPictureActivity.icon;
		newBitmap = CutPictureActivity.icon;
		icon = CutPictureActivity.icon;// 后来加的

		textSize = 60;

		myImageView.setImageBitmap(bitmap0);
		stackBlurManager = new StackBlurManager(bitmap0);

		wallpaperManager = WallpaperManager.getInstance(this);
		fontString = "font/Brand.ttf";
		str1 = "";

		AssetManager assetManager = getApplicationContext().getAssets();
		textView.setShadowLayer(10, 0, 4, R.color.myColor);// 设置阴影
		textView.setTextSize(textSize);// 字体大小
		textView.setTextColor(Color.WHITE);
		textView.setTypeface(Typeface.DEFAULT);

		final Context context = this;

		onClick();

	}

	private void findViewById() {
		mohuButton = (ImageButton) findViewById(R.id.mohu);
		wenziButton = (ImageButton) findViewById(R.id.wenzi);
		quseButton = (ImageButton) findViewById(R.id.quse);

		myImageView = (ImageView) findViewById(R.id.imageView1);
		// myImageView.setOnTouchListener(touch);// 使图片可触摸
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		seekBar.setMax(24);
		textSeekBar = (SeekBar) findViewById(R.id.seekBar_text);
		textSeekBar.setMax(80);
		textSeekBar.setProgress(40);
		tmdSeekBar = (SeekBar) findViewById(R.id.seekBartmd);
		tmdSeekBar.setMax(245);
		tmdSeekBar.setProgress(245);
		editText = (EditText) findViewById(R.id.editText1);
		editText1 = (EditText) findViewById(R.id.editText2);
		// editText2 = (EditText) findViewById(R.id.editText3);
		// editText3 = (EditText) findViewById(R.id.editText4);
		// editText4 = (EditText) findViewById(R.id.editText5);
		saveButton = (ImageButton) findViewById(R.id.save);
		quxiaoButton = (ImageButton) findViewById(R.id.quxiao);
		// saveButton2 = (ImageButton) findViewById(R.id.imageButton_ok2);
		// saveButton3 = (ImageButton) findViewById(R.id.imageButton_ok3);
		// saveButton4 = (ImageButton) findViewById(R.id.imageButton_ok4);
		// saveButton5 = (ImageButton) findViewById(R.id.imageButton_ok5);
		// saveButton6 = (ImageButton) findViewById(R.id.imageButton_ok6);
		// wordButton = (ImageButton) findViewById(R.id.imageButton_word);
		// wordButton2 = (ImageButton) findViewById(R.id.imageButton_word2);
		fontButton = (ImageButton) findViewById(R.id.imageButton_font);
		textsizeButton = (ImageButton) findViewById(R.id.imageButton_textsize);
		colorButton = (ImageButton) findViewById(R.id.imageButton_color);
		shadowButton = (ImageButton) findViewById(R.id.imageButton_shadow);
		addtextButton = (ImageButton) findViewById(R.id.imageButton_addtext);
		addtextButton1 = (ImageButton) findViewById(R.id.imageButton_addtext1);
		// addtextButton2 = (ImageButton)
		// findViewById(R.id.imageButton_addtext2);
		// addtextButton3 = (ImageButton)
		// findViewById(R.id.imageButton_addtext3);
		// addtextButton4 = (ImageButton)
		// findViewById(R.id.imageButton_addtext4);
		haoButton = (ImageButton) findViewById(R.id.imageButton_hao);
		haoButton1 = (ImageButton) findViewById(R.id.imageButton_hao2);
		// haoButton2 = (ImageButton) findViewById(R.id.imageButton_hao3);
		// haoButton3 = (ImageButton) findViewById(R.id.imageButton_hao4);
		// haoButton4 = (ImageButton) findViewById(R.id.imageButton_hao5);
		switch1 = (ToggleButton) findViewById(R.id.switch1);
		switch1.setChecked(true);
		switch_font = (ToggleButton) findViewById(R.id.switch_font);
		switch_font.setChecked(true);
		switch_quse = (ToggleButton) findViewById(R.id.switch_quse);
		switch_quse.setChecked(false);
		handleSelector = (ImageButton) findViewById(R.id.handle_selector);
		wrapSlidingDrawer = (WrapSlidingDrawer) findViewById(R.id.slidingDrawer1);

		tmdButton = (ImageButton) findViewById(R.id.imageButton_tmd);
		tmdInFontButton = (ImageButton) findViewById(R.id.imageButton_tmdInFont);

		// fontInShadowButton = (ImageButton)
		// findViewById(R.id.imageButton_fontInShadow);
		shadowInFontButton = (ImageButton) findViewById(R.id.imageButton_shadowInFont);
		// textsizeInShadowButton = (ImageButton)
		// findViewById(R.id.imageButton_textsizeInShadow);
		// shadowInTextsizeButton = (ImageButton)
		// findViewById(R.id.imageButton_shadowInTextsize);
		// shadowInColorButton = (ImageButton)
		// findViewById(R.id.imageButton_shadowInColor);
		// textsizeInColorButton = (ImageButton)
		// findViewById(R.id.imageButton_textsizeInColor);
		// colorInShadowButton = (ImageButton)
		// findViewById(R.id.imageButton_colorInShadow);
		// colorInTextsizeButton = (ImageButton)
		// findViewById(R.id.imageButton_colorInTextsize);
		textsizeInFontButton = (ImageButton) findViewById(R.id.imageButton_textsizeInFont);
		colorInFontButton = (ImageButton) findViewById(R.id.imageButton_colorInFont);
		fontInFontButton = (ImageButton) findViewById(R.id.imageButton_fontInFont);
		// fontInTextsizeButton = (ImageButton)
		// findViewById(R.id.imageButton_fontInTextsize);
		// fontInColorButton = (ImageButton)
		// findViewById(R.id.imageButton_fontInColor);

		color1Button = (Button) findViewById(R.id.imageButton_color1);
		color2Button = (Button) findViewById(R.id.imageButton_color2);
		color3Button = (Button) findViewById(R.id.imageButton_color3);
		color4Button = (Button) findViewById(R.id.imageButton_color4);
		color5Button = (Button) findViewById(R.id.imageButton_color5);
		color6Button = (Button) findViewById(R.id.imageButton_color6);
		color7Button = (Button) findViewById(R.id.imageButton_color7);
		color8Button = (Button) findViewById(R.id.imageButton_color8);
		color9Button = (Button) findViewById(R.id.imageButton_color9);
		color10Button = (Button) findViewById(R.id.imageButton_color10);
		color11Button = (Button) findViewById(R.id.imageButton_color11);
		color12Button = (Button) findViewById(R.id.imageButton_color12);
		color13Button = (Button) findViewById(R.id.imageButton_color13);
		color14Button = (Button) findViewById(R.id.imageButton_color14);
		color15Button = (Button) findViewById(R.id.imageButton_color15);
		color16Button = (Button) findViewById(R.id.imageButton_color16);
		color17Button = (Button) findViewById(R.id.imageButton_color17);
		color18Button = (Button) findViewById(R.id.imageButton_color18);
		color19Button = (Button) findViewById(R.id.imageButton_color19);
		color20Button = (Button) findViewById(R.id.imageButton_color20);
		color21Button = (Button) findViewById(R.id.imageButton_color21);
		color22Button = (Button) findViewById(R.id.imageButton_color22);
		color23Button = (Button) findViewById(R.id.imageButton_color23);
		color24Button = (Button) findViewById(R.id.imageButton_color24);
		color25Button = (Button) findViewById(R.id.imageButton_color25);
		color26Button = (Button) findViewById(R.id.imageButton_color26);
		color27Button = (Button) findViewById(R.id.imageButton_color27);
		color28Button = (Button) findViewById(R.id.imageButton_color28);
		color29Button = (Button) findViewById(R.id.imageButton_color29);
		color30Button = (Button) findViewById(R.id.imageButton_color30);
		color31Button = (Button) findViewById(R.id.imageButton_color31);
		color32Button = (Button) findViewById(R.id.imageButton_color32);
		color33Button = (Button) findViewById(R.id.imageButton_color33);
		color34Button = (Button) findViewById(R.id.imageButton_color34);
		color35Button = (Button) findViewById(R.id.imageButton_color35);

		font01Button = (ImageButton) findViewById(R.id.imageButton_font01);
		font02Button = (ImageButton) findViewById(R.id.imageButton_font02);
		font03Button = (ImageButton) findViewById(R.id.imageButton_font03);
		font04Button = (ImageButton) findViewById(R.id.imageButton_font04);
		font05Button = (ImageButton) findViewById(R.id.imageButton_font05);
		font06Button = (ImageButton) findViewById(R.id.imageButton_font06);
		font07Button = (ImageButton) findViewById(R.id.imageButton_font07);
		font08Button = (ImageButton) findViewById(R.id.imageButton_font08);
		font09Button = (ImageButton) findViewById(R.id.imageButton_font09);
		font10Button = (ImageButton) findViewById(R.id.imageButton_font10);
		font11Button = (ImageButton) findViewById(R.id.imageButton_font11);
		font12Button = (ImageButton) findViewById(R.id.imageButton_font12);
		font13Button = (ImageButton) findViewById(R.id.imageButton_font13);
		font14Button = (ImageButton) findViewById(R.id.imageButton_font14);
		font15Button = (ImageButton) findViewById(R.id.imageButton_font15);
		font16Button = (ImageButton) findViewById(R.id.imageButton_font16);
		font17Button = (ImageButton) findViewById(R.id.imageButton_font17);
		font18Button = (ImageButton) findViewById(R.id.imageButton_font18);
		font19Button = (ImageButton) findViewById(R.id.imageButton_font19);
		font20Button = (ImageButton) findViewById(R.id.imageButton_font20);
		font21Button = (ImageButton) findViewById(R.id.imageButton_font21);
		font22Button = (ImageButton) findViewById(R.id.imageButton_font22);
		font23Button = (ImageButton) findViewById(R.id.imageButton_font23);
		font24Button = (ImageButton) findViewById(R.id.imageButton_font24);
		font25Button = (ImageButton) findViewById(R.id.imageButton_font25);
		font26Button = (ImageButton) findViewById(R.id.imageButton_font26);
		font27Button = (ImageButton) findViewById(R.id.imageButton_font27);
		font28Button = (ImageButton) findViewById(R.id.imageButton_font28);
		font29Button = (ImageButton) findViewById(R.id.imageButton_font29);
		font30Button = (ImageButton) findViewById(R.id.imageButton_font30);

		morenButton = (ImageButton) findViewById(R.id.imageButton_miaowu);
		miaowuButton = (ImageButton) findViewById(R.id.imageButton_zhiyi);
		daofengButton = (ImageButton) findViewById(R.id.imageButton_changmei);
		shangheiButton = (ImageButton) findViewById(R.id.imageButton_daofeng);
		yueheiButton = (ImageButton) findViewById(R.id.imageButton_tianniu);

		relativeLayout01 = (RelativeLayout) findViewById(R.id.relativeLayout01);
		relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);
		relativeLayoutmore = (RelativeLayout) findViewById(R.id.relativeLayout_more);
		relativeLayoutFont = (RelativeLayout) findViewById(R.id.relativeLayout_font);
		relativeLayoutTextsize = (RelativeLayout) findViewById(R.id.relativeLayout_textsize);
		relativeLayoutTmd = (RelativeLayout) findViewById(R.id.relativeLayout_tmd);
		relativeLayoutColor = (HorizontalScrollView) findViewById(R.id.relativeLayout_color);
		relativeLayoutShadow = (RelativeLayout) findViewById(R.id.relativeLayout_shadow);
		relativeLayoutQuse = (RelativeLayout) findViewById(R.id.relativeLayout_quse);

		horizontalScrollView1 = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
		horizontalScrollView2 = (HorizontalScrollView) findViewById(R.id.horizontalScrollView2);
	};

	private void onClick() {
		// 监听 拖动条
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

				// stackBlurManager.process(progress0 * 2);
				// myImageView.setImageBitmap(stackBlurManager.returnBlurredImage());

				AsyncTaskThread thread = new AsyncTaskThread();
				thread.doInBackground(bitmap0);

				if (progress0 == 0 || progress0 == 1) {
					icon = firstBitmap;
					myImageView.setImageBitmap(firstBitmap);
				}

				// mHandler.post(fadeInTask);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// mHandler.removeCallbacks(fadeInTask);
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
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}
				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				textSize = progress + 20;
				textView.layout(MyTextView.l, MyTextView.t, 0, 0);
				textView.setTextSize(textSize);// 字体大小
			}
		});

		tmdSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

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
				int i = textView.getCurrentTextColor();

				String ii = Integer.toHexString(i);
				String subs = ii.substring((ii.length() - 6), ii.length());
				int progressa = progress + 10;

				String result = "";
				result = Integer.toHexString(progressa);

				if (result.length() % 2 == 1)
					result = "0" + result;

				String iString = "0x" + result + subs;

				Long longStr = Long.parseLong(iString.substring(2), 16);
				int ss = new Integer(longStr.intValue());

				textView.setTextColor(ss);
			}
		});

		switch1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked)
					textView.setShadowLayer(10, 0, 4, R.color.myColor);// 设置无阴影
				else
					textView.setShadowLayer(0, 0, 0, R.color.myColor);// 设置阴影
			}
		});

		switch_font.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					horizontalScrollView2.setVisibility(View.GONE);
					horizontalScrollView1.setVisibility(View.VISIBLE);
				} else {
					horizontalScrollView1.setVisibility(View.GONE);
					horizontalScrollView2.setVisibility(View.VISIBLE);
				}
			}
		});

		switch_quse.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (gray == false) {
					Bitmap icon0 = toGrayscale(icon);
					myImageView.setImageBitmap(icon0);
					gray = true;
				} else {
					myImageView.setImageBitmap(icon);
					gray = false;
				}
			}
		});

		editText.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}
				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
			}
		});

		editText1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}
				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
			}
		});

		mohuButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.VISIBLE);
				relativeLayoutQuse.setVisibility(View.GONE);
				relativeLayoutmore.setVisibility(View.GONE);
			}
		});

		wenziButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				relativeLayout01.setVisibility(View.GONE);
				relativeLayout1.setVisibility(View.VISIBLE);
				relativeLayoutQuse.setVisibility(View.GONE);
				relativeLayoutmore.setVisibility(View.GONE);
				relativeLayoutFont.setVisibility(View.GONE);
				relativeLayoutColor.setVisibility(View.GONE);
				relativeLayoutShadow.setVisibility(View.GONE);
				relativeLayoutTextsize.setVisibility(View.GONE);
				relativeLayoutTmd.setVisibility(View.GONE);

				// sharedpreferences判断
				Editor editor0 = sharedPreferences0.edit();

				if (CutPictureActivity.signal == 1 && first0 == true
						&& first_click == true) {
					editor0.putBoolean("isFirstRun", false);
					editor0.commit();

					first0 = false;
					first_click=false;

					// 首次启动应用 显示用户指导dialog

					dialog0.setContentView(R.layout.dialog_layout);
					RelativeLayout dialogLayout = (RelativeLayout) dialog0
							.findViewById(R.id.dialog);
					dialogLayout.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog0.dismiss();
						}
					});
					dialog0.show();
				} else {
				}
			}
		});

		quseButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				relativeLayout01.setVisibility(View.GONE);
				relativeLayout1.setVisibility(View.GONE);
				relativeLayoutQuse.setVisibility(View.VISIBLE);
				relativeLayoutmore.setVisibility(View.GONE);
				relativeLayoutFont.setVisibility(View.GONE);
				relativeLayoutColor.setVisibility(View.GONE);
				relativeLayoutShadow.setVisibility(View.GONE);
				relativeLayoutTextsize.setVisibility(View.GONE);
				relativeLayoutTmd.setVisibility(View.GONE);
				/*
				 * if (gray == false) { Bitmap icon0 = toGrayscale(icon);
				 * myImageView.setImageBitmap(icon0); gray = true; } else {
				 * myImageView.setImageBitmap(icon); gray = false; }
				 */

			}
		});

		// 监听 保存button
		saveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),
						"成功保存到" + "/sdcard/mofa/" + icon + ".png",
						Toast.LENGTH_LONG).show();

				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}
				textView.setLayoutParams(rl);
				mainLayout.addView(textView);

				icon = convertViewToBitmap(mainLayout);

				Intent intent = new Intent();
				intent.setClass(MainActivity.this, OkActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// 布局文件转换为view对象
		LayoutInflater inflater = LayoutInflater.from(this);
		layout = (RelativeLayout) inflater
				.inflate(R.layout.layout_dialog, null);

		quxiaoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 对话框
				if ((FrameLayout) layout.getParent() != null)
					((FrameLayout) layout.getParent()).removeView(layout);

				final Dialog dialog = new AlertDialog.Builder(MainActivity.this)
						.create();
				dialog.show();
				dialog.getWindow().setContentView(layout);

				// 取消按钮
				Button btnCancel = (Button) layout
						.findViewById(R.id.dialog_cancel);
				btnCancel.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});

				// 确定按钮
				Button btnOK = (Button) layout.findViewById(R.id.dialog_ok);
				btnOK.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent();
						intent.setClass(MainActivity.this,
								ViewpagerActivity.class);
						startActivity(intent);
						finish();
					}
				});

				// 关闭按钮
				ImageButton btnClose = (ImageButton) layout
						.findViewById(R.id.dialog_close);
				btnClose.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				/*
				 * new AlertDialog.Builder(MainActivity.this)
				 * .setIcon(R.drawable.ic_launcher) .setTitle("Mofa")
				 * .setMessage("你确定退出图片编辑吗？") .setPositiveButton("确定", new
				 * DialogInterface.OnClickListener() {
				 * 
				 * @Override public void onClick(DialogInterface dialog, int
				 * which) { Intent intent = new Intent();
				 * intent.setClass(MainActivity.this, ViewpagerActivity.class);
				 * startActivity(intent); finish(); } })
				 * .setNegativeButton("取消", new
				 * DialogInterface.OnClickListener() {
				 * 
				 * @Override public void onClick(DialogInterface dialog, int
				 * which) {
				 * 
				 * } }).show();
				 */
			}
		});

		// 监听 输入文字button
		/*
		 * wordButton.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * relativeLayout01.setVisibility(View.GONE);
		 * relativeLayout1.setVisibility(View.VISIBLE);
		 * editText.setFocusable(true);
		 * 
		 * // seekBar.setPadding(32, 0, 32, 106);// 1080p是(48, 0, 48, 106) } });
		 */

		final String[] singleChoiceItems = { "Brand", "Digetrax", "方正韵动特黑简体",
				"方正综艺", "Kildor", "manteka", "Multicolore", "Meptune8", "Rose",
				"造字公房尚黑" };
		final int defaultSelectedIndex = 0;// 单选框默认值：从0开始

		fontButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutFont.setVisibility(View.VISIBLE);
				relativeLayoutmore.setVisibility(View.VISIBLE);

				// drawNewBitmap(myImageView, str1);
			}
		});

		textsizeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutTextsize.setVisibility(View.VISIBLE);
				relativeLayoutmore.setVisibility(View.VISIBLE);

				// drawNewBitmap(myImageView, str1);
			}
		});

		tmdButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutTmd.setVisibility(View.VISIBLE);
				relativeLayoutmore.setVisibility(View.VISIBLE);
			}
		});

		colorButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutColor.setVisibility(View.VISIBLE);
				relativeLayoutmore.setVisibility(View.VISIBLE);

				// drawNewBitmap(myImageView, str1);
			}
		});

		shadowButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutShadow.setVisibility(View.VISIBLE);
				relativeLayoutmore.setVisibility(View.VISIBLE);

				// drawNewBitmap(myImageView, str1);
			}
		});

		addtextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				str1 = editText.getText().toString();
				textView.layout(MyTextView.l, MyTextView.t, 0, 0);
				textView.setText(str1);
			}
		});

		addtextButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				str1 = editText1.getText().toString();
				textView.layout(MyTextView.l, MyTextView.t, 0, 0);
				textView.setText(str1);
			}
		});

		haoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (icon != null)
					newBitmap = icon;
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}
				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				icon = convertViewToBitmap(mainLayout);
				textView.setText("");
				myImageView.setImageBitmap(icon);
			}
		});

		haoButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (icon != null)
					newBitmap = icon;
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}
				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				icon = convertViewToBitmap(mainLayout);
				textView.setText("");
				myImageView.setImageBitmap(icon);
			}
		});

		color1Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color1));
			}
		});

		color2Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color2));
			}
		});

		color3Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color3));
			}
		});

		color4Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color4));
			}
		});

		color5Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color5));
			}
		});

		color6Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color6));
			}
		});

		color7Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color7));
			}
		});

		color8Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color8));
			}
		});
		color9Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color9));
			}
		});

		color10Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color10));
			}
		});

		color11Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color11));
			}
		});

		color12Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color12));
			}
		});
		color13Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color13));
			}
		});

		color14Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color14));
			}
		});

		color15Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color15));
			}
		});

		color16Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color16));
			}
		});
		color17Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color17));
			}
		});

		color18Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color18));
			}
		});

		color19Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color19));
			}
		});

		color20Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color20));
			}
		});
		color21Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color21));
			}
		});

		color22Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color22));
			}
		});

		color23Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color23));
			}
		});

		color24Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color24));
			}
		});
		color25Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color25));
			}
		});

		color26Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color26));
			}
		});

		color27Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color27));
			}
		});

		color28Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color28));
			}
		});
		color29Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color29));
			}
		});

		color30Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color30));
			}
		});

		color31Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color31));
			}
		});

		color32Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color32));
			}
		});
		color33Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color33));
			}
		});

		color34Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color34));
			}
		});

		color35Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setTextColor(getResources().getColor(R.color.color35));
			}
		});

		font01Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);

				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f1.ttf";

				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font02Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f2.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font03Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f3.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font04Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f4.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font05Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f5.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font06Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f6.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font07Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f7.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font08Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f8.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font09Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f9.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font10Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f10.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font11Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f11.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font12Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f12.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font13Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f13.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font14Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f14.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font15Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f15.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font16Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f16.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font17Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f17.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font18Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f18.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font19Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f19.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font20Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f20.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font21Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f21.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font22Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f22.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font23Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f23.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font24Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f24.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font25Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f25.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font26Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f26.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		font27Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f27.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font28Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f28.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font29Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f29.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		font30Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);
				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/f30.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		morenButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);

				AssetManager assetManager = getApplicationContext().getAssets();
				textView.setTypeface(Typeface.DEFAULT);
			}
		});

		miaowuButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);

				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/miaowu.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		daofengButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);

				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/daofeng.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		shangheiButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);

				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/shanghei.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});
		yueheiButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainLayout.removeView(textView);

				if (MyTextView.l != 0)
					rl.setMargins(MyTextView.l, MyTextView.t, 0, 0);
				else {
					rl.setMargins(getWindowManager().getDefaultDisplay()
							.getWidth() / 2, getWindowManager()
							.getDefaultDisplay().getHeight() / 2, 0, 0);
				}

				textView.setLayoutParams(rl);
				mainLayout.addView(textView);

				AssetManager assetManager = getApplicationContext().getAssets();
				fontString = "font/yuehei.ttf";
				textView.setTypeface(Typeface.createFromAsset(assetManager,
						fontString));
			}
		});

		shadowInFontButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutQuse.setVisibility(View.GONE);
				relativeLayoutmore.setVisibility(View.VISIBLE);
				relativeLayoutShadow.setVisibility(View.VISIBLE);
				relativeLayoutTmd.setVisibility(View.GONE);
				relativeLayoutFont.setVisibility(View.GONE);
				relativeLayoutColor.setVisibility(View.GONE);
				relativeLayoutTextsize.setVisibility(View.GONE);
			}
		});

		textsizeInFontButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutQuse.setVisibility(View.GONE);
				relativeLayoutmore.setVisibility(View.VISIBLE);
				relativeLayoutTextsize.setVisibility(View.VISIBLE);
				relativeLayoutTmd.setVisibility(View.GONE);
				relativeLayoutFont.setVisibility(View.GONE);
				relativeLayoutShadow.setVisibility(View.GONE);
				relativeLayoutColor.setVisibility(View.GONE);
			}
		});

		tmdInFontButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutQuse.setVisibility(View.GONE);
				relativeLayoutmore.setVisibility(View.VISIBLE);
				relativeLayoutTmd.setVisibility(View.VISIBLE);
				relativeLayoutTextsize.setVisibility(View.GONE);
				relativeLayoutFont.setVisibility(View.GONE);
				relativeLayoutShadow.setVisibility(View.GONE);
				relativeLayoutColor.setVisibility(View.GONE);
			}
		});

		colorInFontButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutQuse.setVisibility(View.GONE);
				relativeLayoutmore.setVisibility(View.VISIBLE);
				relativeLayoutColor.setVisibility(View.VISIBLE);
				relativeLayoutTmd.setVisibility(View.GONE);
				relativeLayoutFont.setVisibility(View.GONE);
				relativeLayoutShadow.setVisibility(View.GONE);
				relativeLayoutTextsize.setVisibility(View.GONE);
			}
		});

		fontInFontButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				relativeLayout1.setVisibility(View.GONE);
				relativeLayout01.setVisibility(View.GONE);
				relativeLayoutQuse.setVisibility(View.GONE);
				relativeLayoutmore.setVisibility(View.VISIBLE);
				relativeLayoutFont.setVisibility(View.VISIBLE);
				relativeLayoutTmd.setVisibility(View.GONE);
				relativeLayoutColor.setVisibility(View.GONE);
				relativeLayoutShadow.setVisibility(View.GONE);
				relativeLayoutTextsize.setVisibility(View.GONE);
			}
		});

	};

	/* 设定ImageView的透明度渐显出来 */
	// 没用
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

	public static Bitmap convertViewToBitmap(View v) {
		/*
		 * view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
		 * MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
		 * view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
		 * view.buildDrawingCache(); Bitmap bitmap = view.getDrawingCache();
		 * 
		 * return bitmap;
		 */
		v.clearFocus();
		v.setPressed(false);
		boolean willNotCache = v.willNotCacheDrawing();
		v.setWillNotCacheDrawing(false);
		// Reset the drawing cache background color to fully transparent
		// for the duration of this operation
		int color = v.getDrawingCacheBackgroundColor();
		v.setDrawingCacheBackgroundColor(0);
		if (color != 0) {
			v.destroyDrawingCache();
		}
		v.buildDrawingCache();
		Bitmap cacheBitmap = v.getDrawingCache();
		if (cacheBitmap == null) {
			return null;
		}
		Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
		v.destroyDrawingCache();
		v.setWillNotCacheDrawing(willNotCache);
		v.setDrawingCacheBackgroundColor(color);
		return bitmap;
	}

	// 异步更新
	class AsyncTaskThread extends AsyncTask<String, Integer, Bitmap> {

		protected Bitmap doInBackground(Bitmap bitmap) {

			// 改变模糊上限
			// stackBlurManager.process(progress0 * 2);
			// myImageView.setImageBitmap(stackBlurManager.returnBlurredImage());
			// newBitmap = stackBlurManager.returnBlurredImage();
			// return newBitmap;

			Matrix matrix = new Matrix();
			matrix.postScale(0.25f, 0.25f); // 长和宽放大缩小的比例
			Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0,
					bitmap.getWidth(), bitmap.getHeight(), matrix, true);

			Bitmap result0 = rsBlur(resizeBmp, MainActivity.this, progress0 + 1);
			Bitmap result1 = rsBlur(result0, MainActivity.this, progress0 + 1);
			Bitmap result = rsBlur(result1, MainActivity.this, progress0 + 1);

			// draw(bitmap, "aaa");

			Matrix matrix0 = new Matrix();
			matrix0.postScale(4f, 4f); // 长和宽放大缩小的比例
			Bitmap resizeBmp0 = Bitmap.createBitmap(result, 0, 0,
					result.getWidth(), result.getHeight(), matrix, true);

			myImageView.setImageBitmap(resizeBmp0);
			newBitmap = resizeBmp0;
			icon = newBitmap;

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

	private void draw(Bitmap imageView, String str) {
		Bitmap photo = imageView;

		int width = photo.getWidth();
		int height = photo.getHeight();
		System.out.println("宽" + width + "高" + height);

		icon = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); // 建立一个空的BitMap
		Canvas canvas = new Canvas(icon);// 初始化画布绘制的图像到icon上

		Paint photoPaint = new Paint(); // 建立画笔
		photoPaint.setDither(true); // 获取跟清晰的图像采样
		photoPaint.setFilterBitmap(true);// 过滤一些
		photoPaint.setAntiAlias(true);

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
		imageView = icon;

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

				startY = event.getY();

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

	// 去色
	public static Bitmap toGrayscale(Bitmap bmpOriginal) {
		int width, height;
		height = bmpOriginal.getHeight();
		width = bmpOriginal.getWidth();

		Bitmap bmpGrayscale = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		Canvas c = new Canvas(bmpGrayscale);
		Paint paint = new Paint();
		ColorMatrix cm = new ColorMatrix();
		cm.setSaturation(0);
		ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
		paint.setColorFilter(f);
		c.drawBitmap(bmpOriginal, 0, 0, paint);
		return bmpGrayscale;
	}

}