package com.example.adi18.blood;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

import static com.example.adi18.blood.R.array.bloodtype;

public class Recipient extends AppCompatActivity  {

    SQLiteDatabase database=Donor.db;
    private EditText City,Area;
    private Spinner spin;
    private Button Search;
    String bloodtypes[]={"Select bloodtype","A+","A-","B+","B-","O+","O-","AB+","AB-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        spin = (Spinner) findViewById(R.id.spinners);
        City=(EditText)findViewById(R.id.city);
        Area=(EditText)findViewById(R.id.area);
        Search=(Button)findViewById(R.id.search);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,bloodtypes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
         String s1=spin.getSelectedItem().toString();
        Toast.makeText(this,s1,Toast.LENGTH_LONG).show();
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Recipient.this , Search.class);
                Bundle bun = new Bundle();
                String message = City.getText().toString();
                String message2 = Area.getText().toString();
               final String s=spin.getSelectedItem().toString();
                Toast.makeText(Recipient.this,s,Toast.LENGTH_LONG).show();
                bun.putString("City", message);
                bun.putString("Area", message2);
                bun.putString("Blood",spin.getSelectedItem().toString());
                intent.putExtras(bun);
                startActivity(intent);
            }
        });
       /* spin.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals("Select bloodtype"))
                {}
                else
                {
                   final String item=parent.getItemAtPosition(position).toString();
                     Toast.makeText(parent.getContext(),item,Toast.LENGTH_LONG).show();
                    Search.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent( Recipient.this , Search.class);
                            Bundle bun = new Bundle();
                            String message = City.getText().toString();
                            String message2 = Area.getText().toString();

                            bun.putString("City", message);
                            bun.putString("Area", message2);
                            bun.putString("Blood",item);
                            intent.putExtras(bun);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }*/

    //Performing action onItemSelected and onNothing selected

}}