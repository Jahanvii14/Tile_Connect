package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeScreenActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }


    public void play(View v)
    {
        Intent i=new Intent(getBaseContext(),MenuScreenActivity.class);
        startActivity(i);
        finish();
    }
    public void exit(View v)
    {
        finish();
    }
}
