package com.example.adi18.blood;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity
{
private RecyclerView recyclerView;
private BloodAdapter adapter;
private List<Users> userlists;
DatabaseReference Dref;
String message,message2,message3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Bundle bun = this.getIntent().getExtras();
        message = bun.getString("City");
       message2 = bun.getString("Area");
       message3=bun.getString("Blood");

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userlists = new ArrayList<>();
        adapter=new BloodAdapter(this,userlists);
        recyclerView.setAdapter(adapter);

        //1. SELECT ALL FROM FOO

        Dref=FirebaseDatabase.getInstance().getReference("foo");

        //2.SELECT ALL FROM FOO WHERE bloodtype = message3


        String bloodtype_area=message3+"_"+message2;
        Query query=Dref.orderByChild("bloodtype_area").equalTo(bloodtype_area);

                query.addListenerForSingleValueEvent(valueEventListener);








    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            userlists.clear();
            if (dataSnapshot.exists()) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Users artist = snapshot.getValue(Users.class);
                    userlists.add(artist);



                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

}
