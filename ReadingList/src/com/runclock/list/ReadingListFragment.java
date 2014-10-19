package com.runclock.list;


import com.runclock.list.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;

import android.os.Bundle;

import android.support.v4.app.ListFragment;
import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ReadingListFragment extends ListFragment 
   {
	private static final String TAG = "ReadingList";
	

	 private List<HashMap<String,String>> aList;
	    String[] from = { "student","parent", "signIn", "signOut"};
        int[] to = { R.id.student, R.id.parent,R.id.listin,R.id.listout};        
  
     
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        View header = getActivity().getLayoutInflater().inflate(R.layout.listview_header, null);
         StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
        datasource.open();
        
          int length=datasource.listStudents();
     if (!StudentDataSource.loaded)  {
        this.getListView().addHeaderView(header);
     }
        aList = new ArrayList<HashMap<String,String>>();        
        
        for(int i=0;i<length;i++){
        	HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("student", StudentDataSource.student[i]);
            hm.put("parent", StudentDataSource.parent[i]);
            hm.put("signIn", StudentDataSource.signIn[i]);
            hm.put("signOut", StudentDataSource.signOut[i]);
            		  
            aList.add(hm);        
        }
        
       
          SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);       
         
          setListAdapter(adapter);
  
		 
          super.onActivityCreated(savedInstanceState);
       
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    	super.onCreateOptionsMenu(menu, inflater);
    	inflater.inflate(R.menu.main, menu);
        
        
    
    }
    
   
    public boolean onOptionsItemSelected(MenuItem item) {
    	return true;
    }
   
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) { 
         Log.d(TAG, "getTitle()" + " was clicked");
         Toast.makeText(getActivity().getBaseContext(), TAG + " selected", Toast.LENGTH_LONG).show();
         Intent i = new Intent(getActivity(), CheckinActivity.class);
         Log.v("STUDENTFRAG", Integer.toString(position-1));
         
         i.putExtra(CheckinFragment.STUDENT_ID, StudentDataSource.key[position-1]);
         startActivityForResult(i, 0);
    
    }

  //  public void onListItemClick(ListView l, View v, int position, long id) {
    //    String item = (String) getListAdapter().getItem(position);
   //   Toast.makeText(getActivity().getBaseContext(), item + " selected", Toast.LENGTH_LONG).show();
      //}
	  
 
	


}
