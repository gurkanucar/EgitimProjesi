package com.example.egitimprojesi.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "database";
    private static final int VERSION =1;

    public DataBase(Context context){
        super(context,DB_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("CREATE TABLE test(id INTEGER PRIMARY KEY AUTOINCREMENT,test1 TEXT,test2 TEXT,test3 TEXT, image BLOB)");
      db.execSQL("CREATE TABLE Logs(id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,detail TEXT,date TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
