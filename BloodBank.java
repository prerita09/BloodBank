package com.example.adi18.blood;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class BloodBank extends AppCompatActivity {
    Spinner s1, s2;
    Button Search;
    String sel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        Search = (Button) findViewById(R.id.search);

        final String city[]={"Select city","Delhi","Noida","Pune"};
        final String delhi[]={"Select area","East Delhi","West Delhi","South Delhi","North Delhi"};
        final String noida[]={"Select area","Sector 41","Sector 63","Sector 62","Sector 31","Sector 22","Sector 51","Sector 72","Sector 94A","Sector 27","Sector 33","Sector 26","Sector 11"};
        final String pune[]={"Select area","Kalyani Nagar","Koregaon Park","Aundh"};

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,city);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=city[position];
                Toast.makeText(BloodBank.this,item,Toast.LENGTH_SHORT).show();
                if(position==1)
                {
                    ArrayAdapter<String>adap=new ArrayAdapter<String>(BloodBank.this,android.R.layout.simple_spinner_dropdown_item,delhi);
                s2.setAdapter(adap);
                    Toast.makeText(BloodBank.this,s2.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                }
                if(position==2)
                {
                    ArrayAdapter<String>adap2=new ArrayAdapter<String>(BloodBank.this,android.R.layout.simple_spinner_dropdown_item,noida);
                    s2.setAdapter(adap2);
                    Toast.makeText(BloodBank.this,s2.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                }
                if(position==3)
                {
                    ArrayAdapter<String>adap3=new ArrayAdapter<String>(BloodBank.this,android.R.layout.simple_spinner_dropdown_item,pune);
                    s2.setAdapter(adap3);
                    Toast.makeText(BloodBank.this,s2.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(BloodBank.this,FullData.class);
                intent.putExtra("area",s2.getSelectedItem().toString());
                startActivity(intent);
            }
        });

    }

}
