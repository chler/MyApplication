package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String dbname="mydb";
    public DatabaseHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //账号userId，密码passWord，姓名name，专业subject，电话phone，QQ号qq,地址address
        db.execSQL("create table if not exists users" +
                "(userId varchar(20) primary key," +
                "passWord varchar(20) not null," +
                "name varchar(20)," +
                "subject varchar(20)," +
                "phone varchar(15)," +
                "qq varchar(15)," +
                "address varchar(50))");
        db.execSQL("create table if not exists iteminfo(" +
                "id integer primary key  AUTOINCREMENT," +
                "userId varchar(100)," +
                "title varchar(200)," +
                "kind varchar(100)," +
                "info varchar(1000)," +
               // "price varchar(100)," +
                "image blob," +
                "time DATETIME," +
                "contact varchar(50))");
        db.execSQL("create table if not exists comments(" +
                "userId varchar(100)," +
                "itemId integer," +
                "comment varchar(1000)," +
                "time DATETIME)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

