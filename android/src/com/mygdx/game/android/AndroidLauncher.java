package com.mygdx.game.android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.Swarmup;

public class AndroidLauncher extends AndroidApplication {
	@SuppressLint("NewApi") protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		//config.hideStatusBar = true;
		if (android.os.Build.VERSION.SDK_INT >= 11) {
			try{
				View decorView = getWindow().getDecorView();
				int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
		                | View.SYSTEM_UI_FLAG_FULLSCREEN
		                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
			decorView.setSystemUiVisibility(uiOptions);
				}catch(Exception e){}
		}
		
		initialize(new Swarmup(), config);
	}
	
	@SuppressLint("NewApi") protected void onResume () {
		super.onResume();
		if (android.os.Build.VERSION.SDK_INT >= 11) {
			try{
				View decorView = getWindow().getDecorView();
				int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
		                | View.SYSTEM_UI_FLAG_FULLSCREEN
		                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
			decorView.setSystemUiVisibility(uiOptions);
				}catch(Exception e){}
		}
	}
}
