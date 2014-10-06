package com.runclock.list;


import com.runclock.list.R;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		   ReadingListFragment firstFragment = new ReadingListFragment();

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
			      //fragTransaction.add(R.layout.activity_main,myFrag,"fragments");
			      fragTransaction.replace(R.id.fragment_container,myFrag);
			     fragTransaction.addToBackStack(null);
			       //  transaction.addToBackStack(null);
			      fragTransaction.commit();
			      return true;
			    case R.id.add:
			    	final Dialog dialog1 = new Dialog(this);
					dialog1.setContentView(R.layout.custom);
					dialog1.setTitle("Title...");
					dialog1.show();
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