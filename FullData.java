package com.example.adi18.blood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FullData extends AppCompatActivity {

    TextView a1,a2,a3,a4,a5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_data);

        String a=getIntent().getStringExtra("area");
        if(a.equals("Kalyani Nagar")) {
            a1 = (TextView) findViewById(R.id.textView3);
        a1.setText("LABTECH DIAGNOSTICS SERVICES \n Om Mahavir Complex, Pune Nagar Road,Kalyani Nagar");}
        else if(a.equals("Aundh"))
            {
                a1=(TextView)findViewById(R.id.textView3);
                a1.setText("APOLLO CLINIC \nCentriole 130 ITI Road, Aundh");
                a2=(TextView)findViewById(R.id.textView4);
                a2.setText("MEDIPOINT HOSPITAL \n 241/1 New DP Road, Aundh");
                a3=(TextView)findViewById(R.id.textView5);
                a3.setText("NCORD BLOOD BANK \n Geet Ganga Building, Aundh");
                a4=(TextView)findViewById(R.id.textView6);
                a4.setText("TB HOSPITAL");
            }
            else if(a.equals("Koregaon Park"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("INLAKS AND BUDHRANI \n Sadhu Vaswani Missions Medical Complex, Koregaon Park");
        }
        else if(a.equals("East Delhi"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("LAL BAHADUR SHASTRI HOSPITAL BLOOD BANK, Near Kalyanvas Colony, Mayur Vihar Phase II, Mayur Vihar, Delhi,");
            a2=(TextView)findViewById(R.id.textView4);
            a2.setText("DHARAMSHILA CANCER FOUNDATION AND RESEARCH CENTRE BLOOD BANK \n Vasundhara Enclave, Near New Ashok Nagar Metro Station, New Delhi, Delhi" );
            a3=(TextView)findViewById(R.id.textView5);
            a3.setText("MAX SUPER SPECIALITY HOSPITAL \n Press Enclave Marg ,Saket");
            a4=(TextView)findViewById(R.id.textView6);
            a4.setText("DR HEDGEWAR AROGAYASANSTHAN BLOOD BANK \n Arjun Gali, Vishwas Nagar, Shahdara");
            a5=(TextView)findViewById(R.id.textView6);
            a5.setText("LIONS BLOOD BANK \n Industrial Area, Patparganj");

        }
        else if(a.equals("West Delhi"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("E.S.I. HOSPITAL BLOOD BANK \n Basaidarapur, Near Raja Garden Ring Garden ");
            a2=(TextView)findViewById(R.id.textView4);
            a2.setText("MAHARAJA AGRASEN HOSPITAL BLOOD BANK \n Jain Muni Guru Ramkrishnan Marg, Block C, Shivaji Park, West Punjabi Bagh");
            a3=(TextView)findViewById(R.id.textView5);
            a3.setText("SHREE BALAJI ACTION MEDICAL INSTITUTE BLOOD BANK \n A-4 Block, A-6 Block Paschim Vihar");
            a4=(TextView)findViewById(R.id.textView6);
            a4.setText("DR. B.L. KAPOOR MEMORIAL HOSPITAL BLOOD BANK \n Radha Soama Satsung Rajendra Place, Pusa Road");

        }
        else if(a.equals("North Delhi"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("HINDI RAO HOSPITAL \n  Gandhi Square, Malka Ganj, Delh");
            a2=(TextView)findViewById(R.id.textView4);
            a2.setText("ST.STEPHENS HOSPITAL \n TIS Hazari, Delhi ");
            a3=(TextView)findViewById(R.id.textView5);
            a3.setText("MAX SUPER SPECIALITY HOSPITAL \n C,D Block, Shalimar Bagh ");
            a4=(TextView)findViewById(R.id.textView6);
            a4.setText("SANT PARMANAND HOSPITAL \n 18, Sham Nath Marg, Civil Lines, New Delhi, Delhi");

        }
        else if(a.equals("South Delhi"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("AIIMS BLOOD BANK \n Ansari Nagar East");
            a2=(TextView)findViewById(R.id.textView4);
            a2.setText("SAFDARJUNG HOSPITAL \n 18, Sham Nath Marg, Civil Lines, New Delhi, Delhi");
            a3=(TextView)findViewById(R.id.textView5);
            a3.setText("HOLY FAMILY HOSPITAL \n Okhla Road, Okhla");
            a4=(TextView)findViewById(R.id.textView6);
            a4.setText("NATIONAL HEART INSTITUTE \n 49,50 Community Centre, D-Block, East Of Kailash, Delhi");


        }

        else if(a.equals("Sector 31"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("ROTARY NOIDA BLOOD BANK \n E-2, Opp Ambedkar Hospital, Nithari Village");
        }
        else if(a.equals("Sector 22"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("NOIDA CHARITABLE BLOOD BANK \n I-587, Second Floor, Moolchand Towers,Sector 22 Main Road");
        }
        else if(a.equals("Sector 51"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("OXFORD PATHOLOGY LAB \n Main Road near  VRINDA Garden, Gali No. 4, Hoshiarpur");
        }
        else if(a.equals("Sector 41"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("PRAYAG HOSPITAL BLOOD BANK \n J-206/A1 ");
        }
        else if(a.equals("Sector 63"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("OM CHARITABLE BLOOD BANK \n H-82, Sec 63");
        }
        else if(a.equals("Sector 62"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("FORTIS HOSPITAL BLOOD BANK \n 22 B-Block Rd, Rasoolpur Nawada");
            a2=(TextView)findViewById(R.id.textView4);
            a2.setText("E-RAKT KOSH \n C-56/1 Anusandhan Bhavan");
        }
        else if(a.equals("Sector 94A"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("ROTARY NOIDA BLOOD BANK \n Sector 94A");
        }
        else if(a.equals("Sector 27"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("KAILASH HOSPITAL BLOOD BANK \n H-33 Shaheed Arjun Sardana Marg");
        }
        else if(a.equals("Sector 33"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("PRAKASH HOSPITAL BLOOD BANK \n D-12 Next to ISKCON Temple");
        }
        else if(a.equals("Sector 26"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("APOLLO HOSPITAL \n E-2, Block E");
        }
        else if(a.equals("Sector 11"))
        {
            a1=(TextView)findViewById(R.id.textView3);
            a1.setText("METRO HOSPITAL AND HEART INSTITUTE, Block X,1, Vyapar Marg Budh Vihar");
        }




        }


    }

