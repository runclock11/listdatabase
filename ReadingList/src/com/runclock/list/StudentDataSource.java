package com.runclock.list;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class StudentDataSource {

  // Database fields
  private SQLiteDatabase database;
  private SQLLiteHelper dbHelper;
  public static String name;
  public static String[] student = new String[10];
  public static String[] parent = new String[10];
 private int count =0;
  private String[] allColumns = { SQLLiteHelper.COLUMN_ID,
      SQLLiteHelper.COLUMN_STUDENT,SQLLiteHelper.COLUMN_PARENT,SQLLiteHelper.COLUMN_IN,
      SQLLiteHelper.COLUMN_OUT,SQLLiteHelper.COLUMN_CLASS
     };

  public  StudentDataSource(Context context) {
    dbHelper = new SQLLiteHelper(context);
  }

  public void open() {
	  try {
    database = dbHelper.getWritableDatabase();
   // database.execSQL("DROP TABLE IF EXISTS " + SQLLiteHelper.TABLE_STUDENTS);
    
	  } 
	  
	  catch(SQLException e)  {
		  System.out.print(e.toString());
	  }
  }

  public void close() {
    dbHelper.close();
  }

  public void createStudents() {
 
	  
	database.execSQL("delete from "+ SQLLiteHelper.TABLE_STUDENTS);
 	ContentValues values = new ContentValues();
   	values.put(SQLLiteHelper.COLUMN_STUDENT, "Alden Cooper");
    	values.put(SQLLiteHelper.COLUMN_PARENT,  "Chester & Andrea Cooper");
    	values.put(SQLLiteHelper.COLUMN_IN,  "0");
    	values.put(SQLLiteHelper.COLUMN_OUT,  "0");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Eigth");
      database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
     
          values.put(SQLLiteHelper.COLUMN_STUDENT, "Rondo Cooper");
    	values.put(SQLLiteHelper.COLUMN_PARENT,  "Andrea Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Sixth");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
        
    	Log.v("STUDENT111", "StudentDataSource.name");
        values.put(SQLLiteHelper.COLUMN_STUDENT, "Bella Cooper");
    	values.put(SQLLiteHelper.COLUMN_PARENT,  "Chester  Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "PREK");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values); 
    	
        values.put(SQLLiteHelper.COLUMN_STUDENT, "John Cooper");
    	values.put(SQLLiteHelper.COLUMN_PARENT,  "Florence Cooper");
    	values.put(SQLLiteHelper.COLUMN_IN,  "0");
    	values.put(SQLLiteHelper.COLUMN_OUT,  "0");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Eigth");
       database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
     
          values.put(SQLLiteHelper.COLUMN_STUDENT, "Florence Cooper");
    	values.put(SQLLiteHelper.COLUMN_PARENT,  "John Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Sixth");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
        
    	Log.v("STUDENT111", "StudentDataSource.name");
        values.put(SQLLiteHelper.COLUMN_STUDENT, "Monkey Cooper");
    	values.put(SQLLiteHelper.COLUMN_PARENT,  "Connie Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "PREK");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values); 
        
        Log.v("STUDENT111", "StudentDataSource.name");
        values.put(SQLLiteHelper.COLUMN_STUDENT, "Furman Cooper");
    	values.put(SQLLiteHelper.COLUMN_PARENT,  "Phyllis Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "PREK");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values); 
  }
    public int listStudents() {
       Cursor cursor = database.query(SQLLiteHelper.TABLE_STUDENTS,
                null, null, null, null, null, null);

            cursor.moveToFirst();
            int i =0;
              while (!cursor.isAfterLast()) {
            	  Log.v("STUDENT111", Integer.toString(i));
                  
            	
            	  StudentDataSource.name=  cursor.getString(1);
            	  student[i]= cursor.getString(1);
            	  parent[i]=cursor.getString(2);
            	  i++;
            	  
            	Log.v("STUDENT", StudentDataSource.name);
            	    cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();
    
        database.close();
       
    	return i;
    	
    

   }

 
} 