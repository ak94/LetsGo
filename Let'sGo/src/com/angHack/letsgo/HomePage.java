package com.angHack.letsgo;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class HomePage extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		Button explore=(Button) findViewById(R.id.explore_bt);
		final EditText aabc=(EditText) findViewById(R.id.editText22);
		final TextView abc=(TextView) findViewById(R.id.tv1);
		explore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
					/*boolean diditwork=true;
					try{
					String name=aabc.getText().toString();
					String hotness="123";
					HotOrNot entry=new HotOrNot(HomePage.this);
					entry.open();
					entry.createEntry(name,hotness);
					entry.close();
					}
					catch(Exception e){
						diditwork=false;
						String error=e.toString();
						abc.setText(error);
					}
					finally{
						if(diditwork)
						{
							abc.setText("HURRAY");
						}
					}
				*/
				Intent citi=new Intent("android.intent.action.MAINCAT");
				startActivity(citi);
			}
		});
		Button own=(Button) findViewById(R.id.owner_bt);
		own.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				/*
				HotOrNot info=new HotOrNot(HomePage.this);
				info.open();
				String data=info.getData();
				info.close();
				aabc.setText(data);*/
				// TODO Auto-generated method stub
				Intent own_page=new Intent("android.intent.action.OWNER_PAGE");
				startActivity(own_page);
			}
		});
		
		// Show the Up button in the action bar.
		setupActionBar();
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	

}
