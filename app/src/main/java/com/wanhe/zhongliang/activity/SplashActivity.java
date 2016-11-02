package com.wanhe.zhongliang.activity;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.wanhe.zhongliang.R;
import com.wanhe.zhongliang.base.BaseActivity;
import com.wanhe.zhongliang.utils.SPUtil;

public class SplashActivity extends BaseActivity {
	private Context context;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (!TextUtils.isEmpty((String) SPUtil.get(getApplicationContext(),"isfirstIn"))) {
//				    forward(LoginActivity.class);
			} else {
				    forward(WelcomActivity.class);
			}
			SplashActivity.this.finish();
		};
	};


	/** 3s后跳至主页 */
	private void backgroundThread() {
		new Thread() {
			public void run() {
				try {
					SystemClock.sleep(3000);
					handler.sendEmptyMessage(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	@Override
	public void setContentView() {
		setContentView(R.layout.activity_splash);
	}

	@Override
	public void initView() {

	}


	@Override
	public void initData() {
		backgroundThread();
	}

	@Override
	public void onClick(View v) {

	}
}
