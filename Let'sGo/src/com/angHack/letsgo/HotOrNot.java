package com.angHack.letsgo;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;

public class HotOrNot extends Activity {

	public static final String KEY_USERNAME="username";
	public static final String KEY_PASS="pass";
	public static final String KEY_NAME="shopname";
	public static final String KEY_CATA="primcat";
	public static final String KEY_CATB="seccat";
	public static final String KEY_ADD="add";
	public static final String KEY_TIME="time";
	public static final String KEY_COMM="comm";
	private static final String DATABASE_NAME="hotornotdb1";
	private static final String DATABASE_TABLE="abcTable";
	private static final int DATABASE_VERSION=1;
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static class DbHelper extends SQLiteOpenHelper{
		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL("create table " + DATABASE_TABLE + "("  
			+ KEY_USERNAME + " TEXT, "
			+ KEY_PASS + " TEXT, "
			+ KEY_NAME + " TEXT, "
			+ KEY_CATA + " TEXT, "
			+ KEY_CATB + " TEXT, "
			+ KEY_ADD + " TEXT, "
			+ KEY_TIME + " TEXT, "
			+ KEY_COMM + " TEXT);");
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
		}
		
	}
	
	public HotOrNot(Context c){
		ourContext=c;
	}
	

	public HotOrNot open(){
		ourHelper=new DbHelper(ourContext);
		ourDatabase=ourHelper.getWritableDatabase();
		return this;
		
		
	}
	
	public void close(){
		ourHelper.close();
	}

	public long createEntry(String b,String c,String d,String e,String f,String g,String i,String j) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_USERNAME,b);
		cv.put(KEY_PASS, c);
		cv.put(KEY_NAME, d);
		cv.put(KEY_CATA, e);
		cv.put(KEY_CATB, f);
		cv.put(KEY_ADD, g);
		cv.put(KEY_TIME, i);
		cv.put(KEY_COMM, j);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}
	
	public String getData(){
		
		String[] columns=new String []{KEY_USERNAME,KEY_PASS,KEY_NAME,KEY_CATA,KEY_CATB,KEY_ADD,KEY_TIME,KEY_COMM};
		//String[] columns2=new String []{KEY_USERNAME};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		//Cursor cq=ourDatabase.query(DATABASE_TABLE, columns2, null, null, null, null, null, null);
		String result="";
		int bb=c.getColumnIndex(KEY_USERNAME);
		int cc=c.getColumnIndex(KEY_PASS);
		int dd=c.getColumnIndex(KEY_NAME);
		int ee=c.getColumnIndex(KEY_CATA);
		int ff=c.getColumnIndex(KEY_CATB);
		int gg=c.getColumnIndex(KEY_ADD);
		int ii=c.getColumnIndex(KEY_TIME);
		int jj=c.getColumnIndex(KEY_COMM);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			result=result +
					c.getString(bb)+" "+
					c.getString(cc)+" "+
					c.getString(dd)+" "+
					c.getString(ee)+" "+
					c.getString(ff)+" "+
					c.getString(gg)+" "+
					c.getString(ii)+" "+
					c.getString(jj)+"$";
					
		}
		return result;
	}

}
