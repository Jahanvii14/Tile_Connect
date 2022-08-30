package com.example.a.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterScreenActivity extends ActionBarActivity
{
Database dbb;
    SQLiteDatabase sdb;
    EditText firstnm;
    EditText lastnm;
    EditText emaill;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        dbb=new Database(this);
        sdb=dbb.getWritableDatabase();

        firstnm=(EditText)findViewById(R.id.firstname);
        lastnm=(EditText)findViewById(R.id.lastname);
        emaill=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);

    }

    public void menu(View v)
    {
        String fnm,lnm,email,pawd;
        fnm=firstnm.getText().toString();
        lnm=lastnm.getText().toString();
        email=emaill.getText().toString();
        pawd=pass.getText().toString();

        if (dbb.AddData(fnm,lnm,email,pawd))
        {
            if(fnm.equals(""))
            {
                firstnm.setError("Please Enter your first name");
            }
            else if(lnm.equals(""))
            {
                lastnm.setError("Please enter your last name");
            }
            else if(email.equals(""))
            {
                emaill.setError("Please enter  email");
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                emaill.setError("Please enter valid email");
            }
            else if(pawd.equals(""))
            {
                pass.setError("Please enter password");
            }
            else
            {
                Intent i = new Intent(getApplicationContext(), LoginScreenActivity.class);
                startActivity(i);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"ERROR!Try again",Toast.LENGTH_LONG).show();
        }

       }
   }
