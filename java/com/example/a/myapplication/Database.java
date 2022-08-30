package com.example.a.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Database extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="tile_connect.db";

    private String CREATE_USER_TABLE="CREATE TABLE register(r_id integer primary key Autoincrement,fname text,lname text,email text,password text)";

      public Database(Context context)
      {
          super(context,DATABASE_NAME,null,DATABASE_VERSION);
      }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);

    }

    public  boolean AddData(String fnm,String lnm,String eml,String pwd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("fname",fnm);
        cv.put("lname",lnm);
        cv.put("email",eml);
        cv.put("password",pwd);
        long ans= db.insert("register",null,cv);
        if(ans!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Integer check_login(String eml, String pwd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String Sql="select r_id,email,password from register where email='"+eml+"' and password='"+pwd+"'";
        Cursor c=db.rawQuery(Sql,null);
        if(c.moveToFirst()) {
            int id = c.getInt(c.getColumnIndex("r_id"));
            return id;
        }
        else
        {
            return 0;
        }
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("Drop table if exists register");
        onCreate(db);
    }
}
