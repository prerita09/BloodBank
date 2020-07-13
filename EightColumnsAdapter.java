package com.example.adi18.blood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class EightColumnsAdapter extends ArrayAdapter<User>
{
    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceid;

    public EightColumnsAdapter(Context context, int textViewResouceID, ArrayList<User>users)
    {
        super(context,textViewResouceID,users);
        this.users=users;
        mInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceid=textViewResouceID;

    }

    public View getView(int position, View convertView, ViewGroup parents)
    {
        convertView=mInflater.inflate(mViewResourceid,null);

        User user=users.get(position);

        if(user!=null)
        {
            TextView Nam=(TextView)convertView.findViewById(R.id.Name);
            TextView C=(TextView)convertView.findViewById(R.id.Contact);
            TextView A=(TextView)convertView.findViewById(R.id.Age);
            TextView Blood=(TextView)convertView.findViewById(R.id.BloodType);
            TextView Addr=(TextView)convertView.findViewById(R.id.Address);
            TextView Cit=(TextView)convertView.findViewById(R.id.City);
            TextView IDname=(TextView)convertView.findViewById(R.id.IDProofname);
            TextView IDnumber=(TextView)convertView.findViewById(R.id.IDProofNumber);

            if(Nam!=null)
            {Nam.setText(user.getName());
            }
            if(C!=null)
            {
                C.setText(user.getContact());
            }
            if(A!=null)
            {
                A.setText(user.getAge());
            }
            if(Blood!=null)
            {
                Blood.setText(user.getBloodtype());
            }
            if(Addr!=null)
            {
                Addr.setText(user.getAddress());
            }
            if(Cit!=null)
        {
            Cit.setText(user.getCity());
        }

            if(IDname!=null)
        {
            IDname.setText(user.getIDProofname());
        }
            if(IDnumber!=null)
            {
                IDnumber.setText(user.getIDProofnumber());
            }

        }
        return convertView;

    }



}

