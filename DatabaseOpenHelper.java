package com.example.adi18.blood;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="bloodbank";
    private static final int DATABASE_VERSION=1;
    private static String DB_PATH="C:\\Users\\adi18\\eclipse-workspace\\somya\\app\\src\\Blood\\app\\src\\main\\assets";
    private SQLiteDatabase mDatabase;
    private Context context;

    public DatabaseOpenHelper(Context con)
    {
        super(con,DATABASE_NAME,null,DATABASE_VERSION);
       /* if(Build.VERSION.SDK_INT >=17)
            DB_PATH=con.getApplicationInfo().dataDir+"/databases/";
        else
            DB_PATH="/data/data/"+con.getPackageName()+"/databases/";*/

        context=con;

    }

    public synchronized void close()
    {

        if(mDatabase!=null)
            mDatabase.close();
        super.close();
    }
    public boolean checkDatabase()
    {
        SQLiteDatabase temp=null;
        try
        {
            String path=DB_PATH+DATABASE_NAME;
            temp=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
        }
        catch(SQLiteException e){
        }
        if(temp!=null)
            temp.close();
        return temp!=null?true:false;

    }

    public void copyDatabase()
    {
        try {
            InputStream myInput=context.getAssets().open(DATABASE_NAME);
            String outputFileName=DB_PATH+DATABASE_NAME;
            OutputStream output= new FileOutputStream(outputFileName);

            byte[] buffer=new byte[1024];
            int length;
            while((length=myInput.read(buffer))>0){
                output.write(buffer,0,length);
            }
            output.flush();
            output.close();
            myInput.close();
        }


        catch(IOException e){
            e.printStackTrace();
        }}

    public void openDatabase()
    {
        String path=DB_PATH+DATABASE_NAME;
        mDatabase=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);

    }

    public void createDatabase()
    {
        boolean check=checkDatabase();
        if(check)
        {

        }
        else
        {
            this.getReadableDatabase();
            try{
                copyDatabase();
            }
            catch(Exception e){
                throw new Error("Error copying database");

            }
        }
    }

    public List<Account>getuser(){
        List<Account>tem=new ArrayList<Account>();
        SQLiteDatabase d=this.getWritableDatabase();
        Cursor c;
        try{
            c=d.rawQuery("SELECT * FROM "+DATABASE_NAME,null);
            if(c==null)
                return null;

            c.moveToFirst();
            do{
                Account account=new Account(c.getInt(c.getColumnIndex("SNo")),c.getString(c.getColumnIndex("Name")),c.getString(c.getColumnIndex("City")),c.getString(c.getColumnIndex("Area")));
                tem.add(account);

            }while(c.moveToNext());

            c.close();

        }

        catch(Exception e){


        }

        d.close();
        return tem;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
