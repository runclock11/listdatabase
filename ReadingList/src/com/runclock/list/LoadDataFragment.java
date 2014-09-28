package com.runclock.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LoadDataFragment extends Fragment {

    TextView text,vers;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.textview_layout, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        text.setText("Enter Password");
             return view;
    }
    
}
