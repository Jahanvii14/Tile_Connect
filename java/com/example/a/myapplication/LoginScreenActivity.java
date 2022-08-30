package com.example.a.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginScreenActivity extends ActionBarActivity
{
    Database db;
    SQLiteDatabase sdb;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        db=new Database(this);
        sdb=db.getReadableDatabase();
    }
    public void login(View v)
    {
        String eml,pwd;
        SharedPreferences sp=getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        eml=email.getText().toString();
        pwd=password.getText().toString();
        if(eml.equals(""))
        {
            email.setError("Please enter your mail");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(eml).matches())
        {
            email.setError("Please enter valid email");
        }
        if(pwd.equals(""))
        {
            password.setError("Please enter password");
        }
        else
        {

            int id = db.check_login(eml, pwd);
            if (id != 0)
            {

                Intent i = new Intent(getApplicationContext(), MenuScreenActivity.class);
                startActivity(i);
                finish();
            } else
            {
                Toast.makeText(getApplicationContext(), "Error!Try Again", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void register(View v)
    {
        Intent i=new Intent(getBaseContext(),RegisterScreenActivity.class);
        startActivity(i);
        finish();
    }
    public void skip(View v)
    {
        Intent i= new Intent(getBaseContext(),MenuScreenActivity.class);
        startActivity(i);
        finish();
    }

}