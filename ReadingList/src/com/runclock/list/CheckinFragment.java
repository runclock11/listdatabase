package com.runclock.list;





import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckinFragment extends Fragment {
	 public static final String STUDENT_ID = "checkin.STUDENT_ID";
     private String studentId;
	 public static CheckinFragment newInstance(String studentId) {
	        Bundle args = new Bundle();
	        args.putSerializable(STUDENT_ID, studentId);

	        CheckinFragment fragment = new CheckinFragment();
	        fragment.setArguments(args);

	        return fragment;
	    } 
	public CheckinFragment() {
		
	}
	 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	         studentId = (String)getArguments().getSerializable(STUDENT_ID);
	        StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
	         datasource.open();;
	        datasource.selectStudent(studentId);
	        datasource.close();
	    
	    }

	@Override
	 
	    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.checkin_fragment, container, false);
	        TextView tv1= (TextView)view.findViewById(R.id.studentLabel);
	        tv1.setText(StudentDataSource.student[0]);
;		    TextView tv2= (TextView)view.findViewById(R.id.parentLabel);
            tv2.setText(StudentDataSource.parent[0]);
            Button btndone =(Button)view.findViewById(R.id.donebutton);
            final CheckBox chkSignIn = (CheckBox)view.findViewById (R.id.signin_chk);
            final CheckBox chkSignOut = (CheckBox)view.findViewById (R.id.signout_chk);

            chkSignIn.setOnClickListener(new OnClickListener() {

                  @Override
                  public void onClick(View v) {
                            //is chkIos checked?
                    if (((CheckBox) v).isChecked()) {
                                     //Case 1
                    
                    	StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
              	        datasource.open();
              	      Log.v("STUDENTFRAG0", Boolean.toString(chkSignIn.isChecked()));
              	    Log.v("STUDENTFRAG01", Boolean.toString(chkSignOut.isChecked()));
               	   
              	    datasource.updateStudent(studentId, Boolean.toString(chkSignIn.isChecked()),Boolean.toString(chkSignOut.isChecked()));
              	    datasource.close();
                    	      
                    }
                  }
                });
            
            chkSignOut.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                          //is chkIos checked?
                  if (((CheckBox) v).isChecked()) {
                                   //Case 1
                  
                  	StudentDataSource datasource = new StudentDataSource(getActivity().getBaseContext());
            	        datasource.open();
            	        Log.v("STUDENTFRAG00", Boolean.toString(chkSignIn.isChecked()));
                  		   
                  	    datasource.updateStudent(studentId, Boolean.toString(chkSignIn.isChecked()),Boolean.toString(chkSignOut.isChecked()));
                        
            	          datasource.close();
                  	      
                  }
                }
              });
            btndone.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	   FragmentManager fragMan = getFragmentManager();
           	        FragmentTransaction fragTransaction = fragMan.beginTransaction();

                      Fragment myFrag = new ReadingListFragment();
           	       fragTransaction.replace(R.id.fragment_container,myFrag);
           	    
           	       fragTransaction.commit();
                   }
              });
	        return view;
	    }
}
