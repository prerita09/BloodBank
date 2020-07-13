package com.example.adi18.blood;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    ArrayList<User> userList;
    ListView mlistView;
    User user;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);


        mDatabaseHelper = new DatabaseHelper(this);

        mlistView = (ListView) findViewById(R.id.listView);

        Cursor data = mDatabaseHelper.getData();
        userList = new ArrayList<User>();
        int rows = data.getCount();
        if (rows == 0)
            Toast.makeText(ListDataActivity.this, "Nothing in the database", Toast.LENGTH_LONG).show();

        else {

            while (data.moveToNext()) {
                user = new User(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8));
                userList.add(user);


            }
            EightColumnsAdapter adapter = new EightColumnsAdapter(ListDataActivity.this, R.layout.list_adaptor, userList);
            mlistView.setAdapter(adapter);
        }


        if (userList.size() > 0) {
            final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("foo");
            ref.push().setValue(user);






        }


    }
}





