package com.runclock.list;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NewStudentFragment extends DialogFragment {
      EditText ed1,ed2,ed3;
	
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
       getDialog().setTitle("Add Student");
		View view = inflater.inflate(R.layout.custom, container, false);
		Button btn=(Button)view.findViewById(R.id.okbutton);
		Button btn1=(Button)view.findViewById(R.id.canbutton);
	    ed1= (EditText)view.findViewById(R.id.newFirstName);
	    ed2= (EditText)view.findViewById(R.id.newLastName);
	    ed3= (EditText)view.findViewById(R.id.newParentName);
		
		btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
              
                
                StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
                datasource.open();
           datasource.createStudents(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(),"Prek");
            FragmentManager fragMan = getFragmentManager();
	        FragmentTransaction fragTransaction = fragMan.beginTransaction();

           Fragment myFrag = new ReadingListFragment();
	       fragTransaction.replace(R.id.fragment_container,myFrag);
	         fragTransaction.commit();
           getDialog().dismiss();
            }
            });
		
		
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                getDialog().dismiss();
            }
            
            
            
        }); 
		
		
		
        return view;
    }
}
