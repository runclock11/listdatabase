package com.runclock.list;

import java.util.UUID;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CheckinActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        String studentId = (String)getIntent()
                .getSerializableExtra(CheckinFragment.STUDENT_ID);
       Log.v("STUDENTFRAG1", studentId);
        
        
		 CheckinFragment firstFragment = CheckinFragment.newInstance(studentId);
			   //CheckinFragment firstFragment = new CheckinFragment();

           // In case this activity was started with special instructions from an Intent,
           // pass the Intent's extras to the fragment as arguments
           //firstFragment.setArguments(getIntent().getExtras());

           // Add the fragment to the 'fragment_container' FrameLayout
           getSupportFragmentManager().beginTransaction()
                   .add(R.id.fragment_container, firstFragment).commit();

	}

	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    	
	    	
	    	  switch (item.getItemId()) {
			    case R.id.toast:
			        FragmentManager fragMan = this.getSupportFragmentManager();
			        FragmentTransaction fragTransaction = fragMan.beginTransaction();

			      Fragment myFrag = new LoadDataFragment();
			       fragTransaction.replace(R.id.fragment_container,myFrag);
			     fragTransaction.addToBackStack(null);
			       fragTransaction.commit();
			      return true;
			    case R.id.add:
			    	
			    	 FragmentManager fragMan1 = this.getSupportFragmentManager();
			    	  FragmentTransaction fragTransaction1 = fragMan1.beginTransaction();
                     NewStudentFragment myFrag1 = new NewStudentFragment();
				      myFrag1.show(fragTransaction1, "tag");
			  		    
					    
			    	
			    return true;	
			    default:
			      return super.onOptionsItemSelected(item);
			  }
	        
	    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	}
	

		   
	
	
	
	
	
	
}
