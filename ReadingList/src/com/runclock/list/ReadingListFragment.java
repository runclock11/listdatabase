package com.runclock.list;

import com.runclock.list.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ReadingListFragment extends ListFragment {
	private ListView mainListView;
	 private List<HashMap<String,String>> aList;
	    String[] from = { "student","parent", "to" };
        int[] to = { R.id.student, R.id.parent};        
  
	  
    
   
    
    
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        View header = getActivity().getLayoutInflater().inflate(R.layout.listview_header, null);
        
        StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
        datasource.open();
        datasource.createStudents();
        int length=datasource.listStudents();
        
     
        this.getListView().addHeaderView(header);
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
    
  

    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	
    	  switch (item.getItemId()) {
		    case R.id.toast:
		      Toast.makeText(getActivity().getBaseContext(), R.string.menu_updates, 
		                     Toast.LENGTH_LONG).show();
		      FragmentManager fragMan = getFragmentManager();
		      LinearLayout ll = new LinearLayout(getActivity().getBaseContext());
		      ll.setId(12345);
		      FragmentTransaction fragTransaction = fragMan.beginTransaction();

		      Fragment myFrag = new LoadDataFragment();
		      //fragTransaction.add(R.layout.activity_main,myFrag,"fragments");
		      fragTransaction.replace(R.id.fragment_container,myFrag);
		     fragTransaction.addToBackStack(null);
		       //  transaction.addToBackStack(null);
		      fragTransaction.commit();
		      return true;
		    default:
		      return super.onOptionsItemSelected(item);
		  }
        
    }
    
    
   // @Override
   // public void onCreateView(Bundle savedInstanceState) {
    //	 setHasOptionsMenu(true);
      //   super.onCreate(savedInstanceState);
          
        
    	
	
    //}
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    //	 setHasOptionsMenu(true);
       //  super.onCreate(savedInstanceState);
         return super.onCreateView(inflater, container, savedInstanceState);
        
   
    }  
 
	


}
