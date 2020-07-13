package com.example.adi18.blood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // get the button
        Button donor = (Button) findViewById(R.id.Donor);
        Button recipient = (Button) findViewById(R.id.Recipient);
        Button bloodbank = (Button) findViewById(R.id.BloodBank);

        //on click

        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opendonor();
            }

        });
        recipient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openrecipient();
            }

        });
        bloodbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbloodbank();
            }

        });

    }


    public void opendonor() {
        Intent d = new Intent(this, Donor.class);
        startActivity(d);
    }

    public void openrecipient() {
        Intent r = new Intent(this, Recipient.class);
        startActivity(r);
    }

    public void openbloodbank() {
        Intent b = new Intent(this, BloodBank.class);
        startActivity(b);
    }
}