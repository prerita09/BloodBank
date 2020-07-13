package com.example.adi18.blood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 4/17/2018.
 */

public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.UserViewHolder> {

    private Context context;
    private List<Users> userlists;

    public BloodAdapter(Context context, List<Users> userlists) {
        this.context = context;
        this.userlists = userlists;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Users users = userlists.get(position);
        holder.textViewName.setText(users.name);
        holder.textViewContact.setText("Contact: " + users.contact);
        holder.textViewAge.setText("Age: " + users.age);
        holder.textViewBloodtype.setText("BloodType: " + users.bloodtype);
        holder.textViewArea.setText("Address: " + users.area);
        holder.textViewCity.setText("City: " + users.city);
        holder.textViewID.setText("ID: " + users.idproofname);
        holder.textViewIDno.setText("IDno: " + users.idproofnumber);
        users.bloodtype_area=users.bloodtype+"_"+users.area;
        holder.textViewBTArea.setText(("Bloodtype_Area: "+users.bloodtype_area));



    }

    @Override
    public int getItemCount() {
        return userlists.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName,textViewContact, textViewBloodtype, textViewAge, textViewArea,textViewCity,textViewID,textViewIDno,textViewBTArea;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewBTArea=itemView.findViewById(R.id.btarea);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewContact = itemView.findViewById(R.id.text_view_contact);
            textViewAge = itemView.findViewById(R.id.text_view_age);
            textViewBloodtype = itemView.findViewById(R.id.text_view_bt);
            textViewArea = itemView.findViewById(R.id.text_view_address);
            textViewCity = itemView.findViewById(R.id.text_view_city);
            textViewID = itemView.findViewById(R.id.text_view_id);
            textViewIDno = itemView.findViewById(R.id.text_view_idno);
        }
    }
}
