package com.example.adi18.blood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "DatabaseHelper.db";
    public static final String TABLE_NAME = "people_table";
    public static final String COL1 = "_id";
    public static final String COL2 = "Name";
    public static final String COL3 = "Contact";
    public static final String COL4 = "Age";
    public static final String COL5 = "BloodType";
    public static final String COL6 = "Address";
    public static final String COL7 = "City";
    public static final String COL8 = "IDProofname";
    public static final String COL9 = "IDNumber";


    public DatabaseHelper(Context context) {
        super(context, TAG, null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " Name TEXT, Contact TEXT, Age TEXT, BloodType TEXT, Address TEXT, City TEXT, IDProofname TEXT, IDNumber TEXT)";
        db.execSQL(createTable);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item1, String item2, String item3, String item4, String item5, String item6, String item7, String item8) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);
        contentValues.put(COL4, item3);
        contentValues.put(COL5, item4);
        contentValues.put(COL6, item5);
        contentValues.put(COL7, item6);
        contentValues.put(COL8, item7);
        contentValues.put(COL9, item8);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }


    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        return data;
    }
}