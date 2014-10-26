package com.runclock.list;


import com.runclock.list.R;


import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.content.res.Resources;

import android.os.Bundle;

import android.support.v4.app.ListFragment;
import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ReadingListFragment extends ListFragment 
   {
	private static final String TAG = "ReadingList";
	private StudentDataSource datasource;

	
     
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	String x = StudentDataSource.toJson();
    	Log.d(TAG, x);

        View header = getActivity().getLayoutInflater().inflate(R.layout.listview_header, null);
        datasource = new StudentDataSource(getActivity().getBaseContext());
        datasource.open();
        datasource.listStudents();
        
         if (!StudentDataSource.loaded)  {
        this.getListView().addHeaderView(header);
     }
       
        
       
                
          Resources res =getResources();
          
          CustomAdapter adapters=new CustomAdapter(getActivity(), datasource.studentsList,res );
          setListAdapter(adapters);
		 
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
         i.putExtra(CheckinFragment.STUDENT_ID,  datasource.studentsList.get(position-1).getKey());
         startActivityForResult(i, 0);
    
    }

 	  
 
	


}
