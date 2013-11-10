package com.angHack.letsgo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class FinalView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_final_view);
		TextView final1=(TextView) findViewById(R.id.atv);
		HotOrNot info=new HotOrNot(FinalView.this);
		info.open();
		String data=info.getData();
		info.close();
		final1.setText(data);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.final_view, menu);
		return true;
	}

}
