package com.example.demosqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME="QLSACH";
    public static final String TAG="QLSACH";
    public static final int VERSION=1;
    public static final String  TABLE_NAME="BOOKS";

    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
        getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreatDB= "CREATE TABLE "+ TABLE_NAME + "(id integer primary key autoincrement, name text, page integer, price float, descr text)";
        sqLiteDatabase.execSQL(sqlCreatDB);


    }

    public void excuteSQL(String sql){
        SQLiteDatabase database= getReadableDatabase();
        database.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public Cursor selectSQL(String sql){

        return getReadableDatabase().rawQuery(sql, null);
    }
}
