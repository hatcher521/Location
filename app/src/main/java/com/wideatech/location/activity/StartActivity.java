package com.wideatech.location.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

import com.wideatech.location.R;


public class StartActivity extends Activity {

	private TextView dataTips;
	boolean isFirstIn = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final View view = View.inflate(this, R.layout.layout_start, null);
		setContentView(view);

		dataTips = (TextView) findViewById(R.id.dataloading);

		AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
		aa.setDuration(2000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation arg0) {
				SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(StartActivity.this);

				boolean isLogin = preferences.getBoolean("isLogin", false);

				Intent intent = null;
				if (isLogin){
					intent = new Intent(StartActivity.this,MainActivity.class);

				}else{
					intent = new Intent(StartActivity.this,LoginActivity.class);
				}

				startActivity(intent);
				finish();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationStart(Animation animation) {
			}

		});

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}


}
