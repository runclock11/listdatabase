package com.runclock.list;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter   implements OnClickListener {
    
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList<Students> data;
     public Resources res;
   
    int i=0;
    private static final String TAG = "CustomAdapter";
	

    /*************  CustomAdapter Constructor *****************/
    public CustomAdapter(Activity a, ArrayList<Students> d,Resources resLocal) {
         
           /********** Take passed values **********/
            activity = a;
            data=d;
            res = resLocal;
         
             
    }
 
        public int getCount() {
         
        if(data.size()<=0)
            return 1;
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
     
    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{
         
        public TextView text;
        public TextView text1;
        public TextView text3;
        public TextView text4;
        public ImageView image;
 
    }
 
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {
         
        View vi = convertView;
        ViewHolder holder;
         
        if(convertView==null){
             
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = activity.getLayoutInflater().inflate(R.layout.listview_layout, null);
            
            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.student);
            holder.text1=(TextView)vi.findViewById(R.id.parent);
            holder.text3 = (TextView) vi.findViewById(R.id.listin);
            holder.text4=(TextView)vi.findViewById(R.id.listout);
    
           // holder.image=(ImageView)vi.findViewById(R.id.image);
             
           /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else 
            holder=(ViewHolder)vi.getTag();
         
        if(data.size()<=0)
        {
            holder.text.setText("No Data");
             
        }
        else
        {
          
             
            /************  Set Model values in Holder elements ***********/
             Students std= data.get(position);
             holder.text.setText(std.getFirstname() + " " + std.getLastname());
             holder.text1.setText(std.getParentsName());
             holder.text3.setText(std.getSignIn());
             holder.text4.setText(std.getSignOut());
             
          //    holder.image.setImageResource(
            //              res.getIdentifier(
              //            "com.androidexample.customlistview:drawable/"+tempValues.getImage()
                //          ,null,null));
              
        
             vi.setOnClickListener(new OnItemClickListener( position ));
        }
        return vi;
    }
     
    @Override
    public void onClick(View v) {
            Log.v("CustomAdapter", "=====Row button clicked=====");
    }
     
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements OnClickListener{           
        private int mPosition;
         
        OnItemClickListener(int position){
             mPosition = position;
        }
         
        @Override
        public void onClick(View arg0) {

        	      Intent i = new Intent(activity.getBaseContext(), CheckinActivity.class);
              
              i.putExtra(CheckinFragment.STUDENT_ID,   data.get(mPosition).getKey());
              
              activity.startActivityForResult(i, 0);
      
        }               
    }   
}
