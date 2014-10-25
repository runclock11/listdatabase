package com.runclock.list;


import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;




public class StudentProvider extends ContentProvider {
	static final String PROVIDER_NAME = "com.runclock.list.StudentProvider";
	 static final String URL = "content://" + PROVIDER_NAME + "/students";
	 static final Uri CONTENT_URI = Uri.parse(URL);
	 static final int STUDENTS = 1;
	 static final int STUDENTS_ID = 2;

	 static final UriMatcher uriMatcher;
	   static{
	      uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	      uriMatcher.addURI(PROVIDER_NAME, "students", STUDENTS);
	      uriMatcher.addURI(PROVIDER_NAME, "students/#", STUDENTS_ID);
	   }
	// Database fields
	 private SQLiteDatabase database;
	 private SQLLiteHelper dbHelper;
	 public static String name;
	 public static String[] student = new String[10];
	 public static String[] parent = new String[10];
	 
	 
	 static final String ID = "id";
		
	 // projection map for a query
	 private static HashMap<String, String> BirthMap;
	

	 private String[] allColumns = { SQLLiteHelper.COLUMN_ID,
	     SQLLiteHelper.COLUMN_FIRST,SQLLiteHelper.COLUMN_LAST,SQLLiteHelper.COLUMN_PARENT,SQLLiteHelper.COLUMN_IN,
	     SQLLiteHelper.COLUMN_OUT,SQLLiteHelper.COLUMN_CLASS
	    };  
		
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		  Context context = getContext();
			
		  dbHelper = new SQLLiteHelper(context);
			// permissions to be writable
			database = dbHelper.getWritableDatabase();

		    if(database == null)
		    	return false;
		    else
		    	return true;	
		
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		 SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		 // the TABLE_NAME to query on
		 queryBuilder.setTables(SQLLiteHelper.TABLE_STUDENTS);
	      
	      switch (uriMatcher.match(uri)) {
	      // maps all database column names
	      case STUDENTS:
	    	  queryBuilder.setProjectionMap(BirthMap);
	         break;
	      case STUDENTS_ID:
	    	  queryBuilder.appendWhere( ID + "=" + uri.getLastPathSegment());
	         break;
	      default:
	         throw new IllegalArgumentException("Unknown URI " + uri);
	      }
	      if (sortOrder == null || sortOrder == ""){
	         // No sorting-> sort on names by default
	         sortOrder = SQLLiteHelper.COLUMN_LAST;
	      }
	      Cursor cursor = queryBuilder.query(database, projection, selection, 
	    		  selectionArgs, null, null, sortOrder);
	      /** 
	       * register to watch a content URI for changes
	       */
	      cursor.setNotificationUri(getContext().getContentResolver(), uri);

	      return cursor;
			}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		long row=database.insert(SQLLiteHelper.TABLE_STUDENTS,null, values);
		
		   
		// If record is added successfully
	      if(row > 0) {
	         Uri newUri = ContentUris.withAppendedId(CONTENT_URI, row);
	         getContext().getContentResolver().notifyChange(newUri, null);
	         return newUri;
	      }
	      throw new SQLException("Fail to add a new record into " + uri);
	
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
