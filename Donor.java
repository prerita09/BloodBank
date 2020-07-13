package com.example.adi18.blood;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Donor extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    public static SQLiteDatabase db;
    private EditText age,IDno,ID,number,name,city,address,bloodtype;
    private Button Add,View;
    private Switch tattoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        age=(EditText) findViewById(R.id.age);
        IDno=(EditText) findViewById(R.id.IDno);
        ID=(EditText) findViewById(R.id.ID);
        number=(EditText) findViewById(R.id.number);
        name=(EditText) findViewById(R.id.name);
        city=(EditText) findViewById(R.id.city);
        address=(EditText) findViewById(R.id.address);
        bloodtype=(EditText) findViewById(R.id.bloodtype);
        mDatabaseHelper=new DatabaseHelper(this);
        Add=(Button)findViewById(R.id.buttonAdd);
        View=(Button)findViewById(R.id.buttonViewData);
        tattoo=(Switch)findViewById(R.id.tattoo);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String newEntry1=name.getText().toString();
                String newEntry2=number.getText().toString();
                String newEntry3=age.getText().toString();
                String newEntry4=bloodtype.getText().toString();
                String newEntry5=address.getText().toString();
                String newEntry6=city.getText().toString();
                String newEntry7=ID.getText().toString();
                String newEntry8=IDno.getText().toString();
                if(newEntry1.length()!=0&&newEntry2.length()==10&&Integer.parseInt(newEntry3)>=18&&newEntry5.length()!=0
                        &&newEntry6.length()!=0&&newEntry7.length()!=0&&newEntry8.length()==12||newEntry8.length()==10
                        &&tattoo.isChecked()==false){
                    AddData(newEntry1,newEntry2,newEntry3,newEntry4,newEntry5,newEntry6,newEntry7,newEntry8);

                    name.setText("");
                    number.setText("");
                    age.setText("");
                    bloodtype.setText("");
                    address.setText("");
                    city.setText("");
                    ID.setText("");
                    IDno.setText("");

                }
                else
                    Toast.makeText(Donor.this,"Please enter something in the text field",Toast.LENGTH_LONG).show();
            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Intent intent=new Intent(Donor.this,ListDataActivity.class);
                startActivity(intent);
            }
        });

        }

    public void AddData(String newEntry1,String newEntry2,String newEntry3,String newEntry4,String newEntry5,String newEntry6,String newEntry7,String newEntry8){
        boolean insertData=mDatabaseHelper.addData(newEntry1,newEntry2,newEntry3,newEntry4,newEntry5,newEntry6,newEntry7,newEntry8);
        if(insertData==true)
            toastMessage("Data inserted successfully");
        else
            toastMessage("Something went wrong");


    }

    public void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }


}
