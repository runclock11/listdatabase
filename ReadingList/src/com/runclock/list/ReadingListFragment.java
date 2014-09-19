package com.runclock.list;

import com.runclock.list.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ReadingListFragment extends ListFragment {
	private ListView mainListView;
	 private List<HashMap<String,String>> aList;
	    String[] from = { "train","from", "to" };
     
     // Ids of views in listview_layout
     int[] to = { R.id.train,R.id.from};        
  
	// Array of strings storing country names
    String[] countries = new String[] {
            "Robos, Fludd",
            "India, Fool",
            "South, Korea",
            "Japan, Taokk",
            "Robos, Fludd",
            "India, Fool",
            "South, Korea",
            "Japan, Taokk",
            "Robos, Fludd",
            "India, Fool",
            "South, Korea",
            "Japan, Taokk"
    };    
    
    // Array of integers points to images stored in /res/drawable/
    int[] flags = new int[]{
    		R.drawable.india,
    		R.drawable.pakistan,
    		R.drawable.srilanka,
    		R.drawable.china,
    		R.drawable.bangladesh,
    		R.drawable.nepal,
    		R.drawable.afghanistan,
    		R.drawable.nkorea,
    		R.drawable.skorea,
    		R.drawable.japan	
    };
    
    // Array of strings to store currencies
    String[] currency = new String[]{
    	"North Korean Won",
    	"North Korean",
    	"South Korean Won",
    	"South Korean Won",
    	"North Korean Won",
    	"North Korean",
    	"South Korean Won",
    	"South Korean Won",
    	"North Korean Won",
    	"North Korean",
    	"South Korean Won",
    	"South Korean Won"
    };
    
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        View header = getActivity().getLayoutInflater().inflate(R.layout.listview_header, null);
        
        this.getListView().addHeaderView(header);
     // Each row in the list stores country name, currency and flag
        aList = new ArrayList<HashMap<String,String>>();        
        
        for(int i=0;i<12;i++){
        	HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("train", countries[i]);
            hm.put("from", currency[i]);
            
            		  
            aList.add(hm);        
        }
        
        
          SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);       
		
		setListAdapter(adapter);
          
      
   
        super.onActivityCreated(savedInstanceState);
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	  
            super.onCreate(savedInstanceState);
          
        
    	
	
    }
    
   
    
 
	


}
