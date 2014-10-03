package com.runclock.list;


import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.app.FragmentTransaction.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;


public class LoadDataFragment extends Fragment  implements OnClickListener {

    TextView text,vers;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textview_layout, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        text.setText("Enter Password");
        StudentDataSource.loaded=true;
        btn = (Button) view.findViewById(R.id.button1);
        btn.setOnClickListener(this);  
        
        return view;
    }
    
    
    public void onClick(View v) {
    	loadData();/*
    	String a= text.toString();
        if (text.getText().toString().equals("runclock")) {
        	    loadData();
        }
        else {
        	 Toast.makeText(this.getActivity(), 
        	            "Password incorrect",10).show();
        	  
        }*/

    }
    public void loadData() {
    	 StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
         datasource.open();
         datasource.createStudents();
         FragmentManager fragmentManager = getFragmentManager();
         fragmentManager.popBackStack();
     	    
        
         
       
		   
        
         
  

      //   fragmentTransaction.replace(R.id.fragment_container,fragment2);
		 
        //   fragmentTransaction.commit();
     
    }
}
