package com.junfei.menu;

import com.junfei.menu.ui.YoukuMenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private YoukuMenu ykm;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ykm = (YoukuMenu) findViewById(R.id.ykm);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
			ykm.switchMenu();
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
			ykm.switchMenu();	
		super.onOptionsMenuClosed(menu);
	}
}
