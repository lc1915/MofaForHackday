package com.unique.mofaforhackday;

import javax.security.auth.PrivateCredentialPermission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class AboutActivity extends Activity{
	
	private ImageButton imageButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去标题栏
		setContentView(R.layout.about_activity);
		
	}
}
