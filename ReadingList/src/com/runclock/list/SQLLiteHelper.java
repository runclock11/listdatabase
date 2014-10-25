package com.runclock.list;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

public class SQLLiteHelper extends SQLiteOpenHelper {
public static final String TABLE_STUDENTS = "students17";
public static final String COLUMN_ID = "_id";
public static final String COLUMN_FIRST = "student_first";
public static final String COLUMN_LAST = "student_last";
public static final String COLUMN_PARENT = "parent_name";
public static final String COLUMN_IN = "signIn";
public static final String COLUMN_OUT = "signOut";
public static final String COLUMN_CLASS = "class";

private static final int DATABASE_VERSION = 1;
private static final String DATABASE_CREATE = "create table "
    + TABLE_STUDENTS + "(" + COLUMN_ID
    + " integer primary key autoincrement, " +
    COLUMN_FIRST + " text, " +
    COLUMN_LAST + " text, " +
    COLUMN_PARENT  + " text, " +
    COLUMN_IN      + " text, " +
    COLUMN_OUT  + " text, " +
    COLUMN_CLASS  + " text" +
    ");";





private static final String DATABASE_NAME = "students17.db";
public SQLLiteHelper(Context context) {
	
    
  super(context, DATABASE_NAME, null, DATABASE_VERSION);
  Log.v("STUDENT11100", "StudentDataSource.name");
}

  @Override
  public void onCreate(SQLiteDatabase database) {
	  Log.v("STUDENTxxxxx", DATABASE_CREATE);
      
  database.execSQL(DATABASE_CREATE);
}

	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}



