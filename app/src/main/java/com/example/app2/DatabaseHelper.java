package com.example.app2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME =  "DETAILS.db";
    public static final String TABLE_NAME = "DETAILS_TABLE";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "AGE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1); //whenever this constructor is called, a database will be created
    }


    @Override
    public void onCreate(SQLiteDatabase db) { //table is created on calling this.
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " ( NAME TEXT, AGE INTEGER)");//executes whatever query you pass inside this method as argument

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String age)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" SELECT * FROM " +TABLE_NAME,null);
        return res;
    }

}




