package com.unique.mofaforhackday;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector.OnGestureListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FankuiActivity extends Activity implements OnTouchListener,
		OnGestureListener {

	private GestureDetector mGestureDetector;
	private int verticalMinDistance = 20;  
	private int minVelocity         = 0;  
	
	private Button button;
	private Button mButton;
	private EditText editText1;
	private EditText editText2;
	private Handler mHandler;
	private String fkr="";
	private String fknr="";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.fankui_activity);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		
		mButton = (Button)this.findViewById(R.id.Button1);
        //按钮监听
        mButton.setOnClickListener(new View.OnClickListener() 
        {
            
            @Override
            public void onClick(View v) 
            {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
				intent.setClass(FankuiActivity.this, ViewpagerActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left); 
				finish();
            }
        });

		mGestureDetector = new GestureDetector((OnGestureListener) this);
		// 给布局文件添加事件
		RelativeLayout viewSnsLayout = (RelativeLayout) findViewById(R.id.fankui_relativelayout);
		viewSnsLayout.setOnTouchListener(this);
		viewSnsLayout.setLongClickable(true);
		
		button=(Button)findViewById(R.id.button1);
		editText1=(EditText)findViewById(R.id.edittext1);
		editText2=(EditText)findViewById(R.id.edittext2);
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*Uri uri = Uri.parse("mailto:284129606@qq.com");   
				String[] email = {"284129606@qq.com"};  
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);  
				intent.putExtra(Intent.EXTRA_CC, email); // 抄送人  
				intent.putExtra(Intent.EXTRA_SUBJECT, "mofa问题反馈"); // 主题  
				intent.putExtra(Intent.EXTRA_TEXT, "邮件的正文部分"); // 正文  
				startActivity(Intent.createChooser(intent, "请选择邮件类应用"));  */
				
				Toast.makeText(getApplicationContext(), "反馈成功！", Toast.LENGTH_SHORT);
				
				mHandler = new Handler() {  
					@Override  
			        public void handleMessage(Message msg) {//执行接收到的通知，此时执行的顺序是按照队列进行，即先进先出   
			            super.handleMessage(msg);  
			            Bundle b=msg.getData();   
			            String textStr1=b.getString("textStr");  
			            
			            Toast.makeText(getApplicationContext(), textStr1+"fankui", Toast.LENGTH_SHORT);
			            }   
			        };//该线程将会在单独的线程中运行   
				
				new Thread(new Runnable() {
			        public void run() {
			        	
			        	Looper.prepare();

			        	fkr=editText1.getText().toString();
						fknr=editText2.getText().toString();
			            Message msg = new Message();
			            HttpPost httpRequest = new HttpPost("http://ftssoft.duapp.com/feedback_api.php");
			            List<NameValuePair> params = new ArrayList<NameValuePair>();
			            params.add(new BasicNameValuePair("code","5414219"));
			            params.add(new BasicNameValuePair("kfz","lc1915"));
			            params.add(new BasicNameValuePair("xmmc","mofa"));
			            params.add(new BasicNameValuePair("fkr", fkr));
			            params.add(new BasicNameValuePair("fknr", fknr));
			            try {
			                httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
			                if (httpResponse.getStatusLine().getStatusCode() == 200) {
			                    //获取返回的信息
			                    String strResult = EntityUtils.toString(httpResponse.getEntity());
			                    msg.obj = strResult;
			                } else {
			                    msg.obj = "Error Response";
			                }
			            } catch (Exception e) {
			                msg.obj = "请检查网络连接 ";
			                e.printStackTrace();
			            }
			            Toast.makeText(getApplicationContext(), msg.obj+"", Toast.LENGTH_SHORT).show();
			            mHandler.sendEmptyMessage(0);
			            
			            Looper.loop();// 进入loop中的循环，查看消息队列
			        }
			    }).start();
				
			}
		});

	}

	

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		if (e1.getX() - e2.getX() > 10) {

			Intent intent = new Intent(FankuiActivity.this,
					ViewpagerActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
			finish();
		} else if (e2.getX() - e1.getX() > snsConstant.getFlingMinDistance()
				&& Math.abs(velocityX) > snsConstant.getFlingMinVelocity()) {

			/*Intent intent = new Intent(FankuiActivity.this,
					ViewpagerActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
			// Toast.makeText(this, "向右手势", Toast.LENGTH_SHORT).show();
			finish();*/
		}
		return false;
	}
	
	public boolean onTouch(View v, MotionEvent event) {  
	    return mGestureDetector.onTouchEvent(event);  
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

}
