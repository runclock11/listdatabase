package com.runclock.list;

import com.runclock.list.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ReadingListFragment extends ListFragment 
   {
	private ListView mainListView;
	 private List<HashMap<String,String>> aList;
	    String[] from = { "student","parent", "to" };
        int[] to = { R.id.student, R.id.parent};        
  
	  
    
   
    
    
    
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  		 
         return super.onCreateView(inflater, container, savedInstanceState);
        
   
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(getActivity().getBaseContext(), item + " selected", Toast.LENGTH_LONG).show();
      }
	  
 
	


}
