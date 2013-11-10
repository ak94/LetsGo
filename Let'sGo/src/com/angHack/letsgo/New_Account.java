package com.angHack.letsgo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class New_Account extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new__account);
		Button create=(Button) findViewById(R.id.create_bt);
		final RadioButton a1=(RadioButton) findViewById(R.id.radioButton1);
		final RadioButton a2=(RadioButton) findViewById(R.id.radioButton2);
		final RadioButton a3=(RadioButton) findViewById(R.id.radioButton3);
		final RadioButton a4=(RadioButton) findViewById(R.id.radioButton4);
		final RadioButton a5=(RadioButton) findViewById(R.id.radioButton5);
		final RadioButton a6=(RadioButton) findViewById(R.id.radioButton6);
		final RadioButton a7=(RadioButton) findViewById(R.id.radioButton7);
		final RadioButton a8=(RadioButton) findViewById(R.id.radioButton8);
		final EditText name1=(EditText) findViewById(R.id.editText1);
		final EditText time=(EditText) findViewById(R.id.editText2);
		final EditText sname=(EditText) findViewById(R.id.shop_name_et);
		final EditText adder=(EditText) findViewById(R.id.add_et);
		
		create.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String h1 = null,h2 = null;
				if(a1.isSelected())h1="mall";
				if(a2.isSelected())h1="shop";
				if(a3.isSelected())h1="hotel";
				if(a4.isSelected())h1="restaurant";
				
				if(a5.isSelected())h2="electronics";
				if(a6.isSelected())h2="books";
				if(a7.isSelected())h2="sports";
				if(a8.isSelected())h2="clothes";
				String password="";
				boolean diditwork=true;
				HotOrNot entry=new HotOrNot(New_Account.this);
				entry.open();
				String ab=name1.getText().toString()+" "+password+" "+sname.getText().toString()+" "+h1+" "+h2+" "+adder.getText().toString()+" "+time.getText().toString()+" "+"abcd";
				name1.setText(ab);
				entry.createEntry(name1.getText().toString(),password,sname.getText().toString(),"h1","h2",adder.getText().toString(),time.getText().toString(),"abcd");
				entry.close();
				/*
				catch(Exception e){
					diditwork=false;
					String error=e.toString();
					//name1.setText(error);
				}
				finally{
					if(diditwork)
					{
						//name1.setText("HURRAY");
					}*
				}*/
				
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
		getMenuInflater().inflate(R.menu.new__account, menu);
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
