package com.example.adi18.blood;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Area extends AppCompatActivity {

    List<Account> user=new ArrayList<Account>();
    DatabaseOpenHelper db;
    LinearLayout container;
    Button button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);
container=(LinearLayout)findViewById(R.id.container);
button=(Button)findViewById(R.id.button);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

       // Toast.makeText(Area.this, "hellooooooooo", Toast.LENGTH_SHORT).show();
        db=new DatabaseOpenHelper(Area.this);

        try {
            db.createDatabase();
        }
        catch(SQLException e)
        {
            throw new Error("Unable to create database");
        }
        try
        {
            db.openDatabase();
        }
        catch(SQLException ex)
        {
            throw ex;
        }



        Toast.makeText(Area.this,"success",Toast.LENGTH_SHORT).show();

        user=db.getuser();
        for(Account account : user){
            LayoutInflater inflater=(LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View addview=inflater.inflate(R.layout.row,null);
            TextView textid=(TextView)addview.findViewById(R.id.sno);
            TextView textname=(TextView)addview.findViewById(R.id.textname);
            TextView textcity=(TextView)addview.findViewById(R.id.textcity);
            TextView textarea=(TextView)addview.findViewById(R.id.textarea);

            textid.setText(account.getSNo());
            textname.setText(account.getName());
            textcity.setText(account.getCity());
            textarea.setText(account.getArea());


            container.addView(addview);

        }

    }
});

    }
}
