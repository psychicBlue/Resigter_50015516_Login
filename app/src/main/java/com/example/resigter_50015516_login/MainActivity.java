package com.example.resigter_50015516_login;

import androidx.appcompat.app.AppCompatActivity;
import gr.net.maroulis.library.EasySplashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //Hide action bar


        //Using Handler and Intent to display splash screen for 3 seconds
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}