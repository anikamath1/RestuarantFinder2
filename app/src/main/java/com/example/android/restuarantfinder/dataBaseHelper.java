package com.example.android.restuarantfinder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class dataBaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "restaurant1.db";
//    public static final String TABLE_NAME = "restDetails_table";
//    public static final String COL_1 = "restID";
//    public static final String COL_2 = "restName";
    private static final int dbVersion = 2;

    private static final String TAG = "dataBaseHelper";

    //whenever this const is called db is created
    public dataBaseHelper(Context context)
    {
        super(context,DATABASE_NAME, null, dbVersion);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase(); //save the database
    }

    //very first time when the file is run
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

//        String query = "create table" + TABLE_NAME + "(" + COL_1 + "INTEGER PRIMARY KEY AUTOINCREMENT" + "," +
//                COL_2 + "TEXT" + ");";
        String query = "create table restDetails_table (restID INTEGER PRIMARY KEY AUTOINCREMENT, restName TEXT, restAddress TEXT );";
        sqLiteDatabase.execSQL(query);


    }

//    public Cursor getRestName(String restName, SQLiteDatabase sqLiteDatabase)
//    {
//        String[] projection = {"restName", "restAddress"};
//        String select = "restName LIKE ?";
//        String[] selection_param = {restName};
//        Cursor cursor = sqLiteDatabase.query("restDetails_table", projection, select, selection_param, null, null, null);
//        return cursor;
//    }


    //when you upgrade version
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS restDetails_table "); //when upgrade drop previous table
//        onCreate(sqLiteDatabase);
        if (newVersion == 2) {
            sqLiteDatabase.execSQL("ALTER TABLE restDetails_table ADD COLUMN restAddress TEXT");
        }

    }
}
