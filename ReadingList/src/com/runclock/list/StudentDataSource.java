package com.runclock.list;



import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

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
  public ArrayList<Students> studentsList = new ArrayList<Students>();  
  public static boolean loaded=false;

  private String[] allColumns = { SQLLiteHelper.COLUMN_ID,
      SQLLiteHelper.COLUMN_FIRST,SQLLiteHelper.COLUMN_LAST,SQLLiteHelper.COLUMN_PARENT,SQLLiteHelper.COLUMN_IN,
      SQLLiteHelper.COLUMN_OUT,SQLLiteHelper.COLUMN_CLASS
     };

  public  StudentDataSource(Context context) {
    dbHelper = new SQLLiteHelper(context);
  }

  public void open() {
	  try {
    database = dbHelper.getWritableDatabase();
    
	  } 
	  
	  catch(SQLException e)  {
		  System.out.print(e.toString());
	  }
  }

  public void close() {
    dbHelper.close();
  }

  public void deleteStudents() {
	  database.execSQL("delete from "+ SQLLiteHelper.TABLE_STUDENTS);
	  database.close();
  }
  public void createStudents(String studentfirst,String studentlast, String parent, String className) {
	  ContentValues values = new ContentValues();
	   	values.put(SQLLiteHelper.COLUMN_FIRST, studentfirst);
	   	values.put(SQLLiteHelper.COLUMN_LAST, studentlast);
		   values.put(SQLLiteHelper.COLUMN_PARENT,  parent);
	    	values.put(SQLLiteHelper.COLUMN_IN,  "0");
	    	values.put(SQLLiteHelper.COLUMN_OUT,  "0");
	    	values.put(SQLLiteHelper.COLUMN_CLASS,  className);
	      database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
	      database.close();

  }
  
  public int updateStudent(String id,String in, String out) {
	  ContentValues values = new ContentValues();
	    values.put(SQLLiteHelper.COLUMN_IN, in);
	    values.put(SQLLiteHelper.COLUMN_OUT, out);
	 
	    // updating row
	    int result= database.update(SQLLiteHelper.TABLE_STUDENTS, values, "_id  = ?",
	            new String[] { String.valueOf(id) });
	    return result;
  }
  public Students selectStudent(String id) {
	  
	 
	  // 2. build query
	    Cursor cursor = 
	            database.query(SQLLiteHelper.TABLE_STUDENTS, // a. table
	            allColumns, // b. column names
	            " _id = ?", // c. selections 
	            new String[] { String.valueOf(id) }, // d. selections args
	            null, // e. group by
	            null, // f. having
	            null, // g. order by
	            null); // h. limit
	    
	    // 3. if we got results get the first one
	    if (cursor != null)
	        cursor.moveToFirst();
	   Students std = new Students();
	   std.setKey(cursor.getString(0));
	   std.setFirstname(cursor.getString(1));
       std.setLastname(cursor.getString(2));
       std.setParentsName(cursor.getString(3));
       std.setSignIn(cursor.getString(4));
       std.setSignOut(cursor.getString(5));
	   return std;
	   
	  }
  public void createStudents() {
 
	  
	database.execSQL("delete from "+ SQLLiteHelper.TABLE_STUDENTS);
 	ContentValues values = new ContentValues();
   	values.put(SQLLiteHelper.COLUMN_FIRST, "Chester");
	values.put(SQLLiteHelper.COLUMN_LAST, "Cooper");
	       values.put(SQLLiteHelper.COLUMN_PARENT,  "Chester & Andrea Cooper");
    	values.put(SQLLiteHelper.COLUMN_IN,  "1");
    	values.put(SQLLiteHelper.COLUMN_OUT,  "2");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Eigth");
      database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
     
   	values.put(SQLLiteHelper.COLUMN_FIRST, "Alden");
  	values.put(SQLLiteHelper.COLUMN_LAST, "Cooper");

         	values.put(SQLLiteHelper.COLUMN_PARENT,  "AndreaCooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Sixth");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
        
    	Log.v("STUDENT111", "StudentDataSource.name");
        values.put(SQLLiteHelper.COLUMN_FIRST, "Justin");
        values.put(SQLLiteHelper.COLUMN_LAST, "Cooper");
        values.put(SQLLiteHelper.COLUMN_PARENT,  "Chester  Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "PREK");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values); 
    	
    	values.put(SQLLiteHelper.COLUMN_FIRST, "Berry");
      	values.put(SQLLiteHelper.COLUMN_LAST, "Cooper");

     	values.put(SQLLiteHelper.COLUMN_PARENT,  "Towswon Cooper");
    	values.put(SQLLiteHelper.COLUMN_IN,  "0");
    	values.put(SQLLiteHelper.COLUMN_OUT,  "0");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Eigth");
       database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
     
   	values.put(SQLLiteHelper.COLUMN_FIRST, "Andrea");
  	values.put(SQLLiteHelper.COLUMN_LAST, "Cooper");
 	values.put(SQLLiteHelper.COLUMN_PARENT,  "Monkey Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "Sixth");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
        
    	Log.v("STUDENT111", "StudentDataSource.name");
    	values.put(SQLLiteHelper.COLUMN_FIRST, "Monkey");
      	values.put(SQLLiteHelper.COLUMN_LAST, "Cooper");

      	values.put(SQLLiteHelper.COLUMN_PARENT,  "Connie Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "PREK");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values); 
        
        Log.v("STUDENT111", "StudentDataSource.name");
    	values.put(SQLLiteHelper.COLUMN_FIRST, "Furman");
      	values.put(SQLLiteHelper.COLUMN_LAST, "Cooper");

      	values.put(SQLLiteHelper.COLUMN_PARENT,  "Phyllis Cooper");
    	values.put(SQLLiteHelper.COLUMN_CLASS,  "PREK");
        database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values); 
        database.close();
  }
    public int listStudents() {
       String sql="SELECT * from " + SQLLiteHelper.TABLE_STUDENTS + " order by " + SQLLiteHelper.COLUMN_LAST 
    		   + "," + SQLLiteHelper.COLUMN_FIRST;
       Cursor cursor = database.rawQuery(sql, null);  
       int size=cursor.getCount();
           studentsList = new ArrayList<Students>(size);
            cursor.moveToFirst();
            int i =0;
              while (!cursor.isAfterLast()) {
            	  Log.v("STUDENT111", Integer.toString(i));
                  
            	
            	  Students std = new Students();
            	  StudentDataSource.name=  cursor.getString(1);
            	  std.setKey(cursor.getString(0));
            	  std.setFirstname(cursor.getString(1));
            	  std.setLastname(cursor.getString(2));
            	  std.setParentsName(cursor.getString(3));
            	  std.setSignIn(cursor.getString(4));
            	  std.setSignOut(cursor.getString(5));
                  
            	  studentsList.add(std);
            	  i++;
            	  
            	Log.v("STUDENT", studentsList.toString());
            	    cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();
    
        database.close();
       
    	return i;
    	
    

   }
public static String toJson() {
	String input ="{	\"year\": \"2014\",\n" + 
			"	\"name\": \"Youth Sunday School\",\n" + 
			"	\"classes\":\n" + 
			"		{\n" + 
			"			\"prek\":\n" + 
			"				[\n" + 
			"					{ \"firstname\": \"Chester\", \"lastname\":\"Andrea Cooper\", \"signin\":\"false\", \"signout\":\"false\" },\n" + 
			"							{ \"firstname\": \"Russell\", \"lastname\":\"Brown\", \"signin\":\"false\", \"signout\":\"false\" },      		        { \"firstname\": \"Chester\", \"lastname\":\"Tesla\", \"signin\":\"false\", \"signout\":\"false\" },		               { \"firstname\": \"Chester\", \"lastname\":\"Smith\", \"signin\":\"false\", \"signout\":\"false\" },	                	{ \"firstname\": \"Chester\", \"lastname\":\"Cooper\", \"signin\":\"false\", \"signout\":\"false\" },	                	{ \"firstname\": \"Chester\", \"lastname\":\"Kay\", \"signin\":\"false\", \"signout\":\"false\" },\n" + 
			"         { \"firstname\": \"Chester\", \"lastname\":\"Wilson\", \"signin\":\"false\", \"signout\":\"false\" }\n" + 
			"         ],\n" + 
			"				\"beginner\":\n" + 
			"				[\n" + 
			"			{ \"firstname\": \"Chester\", \"lastname\":\"Andrea Cooper\", \"signin\":\"false\", \"signout\":\"false\" },\n" + 
			"						{ \"firstname\": \"Chester\", \"lastname\":\"Andrea Cooper\", \"signin\":\"false\", \"signout\":\"false\" }\n" + 
			"				]\n" + 
			"		}\n" + 
			"}";
	//JSONObject jsonObj = new JSONObject();
	  try {
		JSONObject json = new JSONObject(input);
		return json.toString();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	      
	
	return "";
}
 
} 