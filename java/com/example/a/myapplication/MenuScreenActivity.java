package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class MenuScreenActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
    }

    public void abc(View v)
    {
            Intent intent = new Intent(getBaseContext(), AbcScreenActivity.class);
            startActivity(intent);
            finish();

    }
    public void number(View v)
    {
        Intent intent = new Intent(getBaseContext(),NumberScreenActivity.class);
        startActivity(intent);
        finish();
    }
    public void color(View v)
    {
        Intent intent = new Intent(getBaseContext(),ColorScreenActivity.class);
        startActivity(intent);
        finish();
    }
    public void shape(View v)
    {
        Intent intent = new Intent(getBaseContext(), ShapeScreenActivity.class);
        startActivity(intent);
        finish();

    }
   }
