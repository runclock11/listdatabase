package com.runclock.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoadDataFragment extends Fragment  implements OnClickListener {

    TextView text,vers;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textview_layout, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        text.setText("Enter Password");

        btn = (Button) view.findViewById(R.id.button1);
        btn.setOnClickListener(this);  
        
        return view;
    }
    
    
    public void onClick(View v) {
    	String a= text.toString();
        if (text.getText().toString().equals("runclock")) {
        	    loadData();
        }
        else {
        	 Toast.makeText(this.getActivity(), 
        	            "Password incorrect",10).show();
        	  
        }

    }
    public void loadData() {
    	 StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
         datasource.open();
         datasource.createStudents();
     
    }
}
