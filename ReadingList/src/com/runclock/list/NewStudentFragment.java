package com.runclock.list;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewStudentFragment extends DialogFragment {

	
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
       getDialog().setTitle("Add Student");
		View view = inflater.inflate(R.layout.custom, container, false);
         
        return view;
    }
}
