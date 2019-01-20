package com.example.mvishal.loginsignup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.mvishal.loginsignup.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent intentLogin = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intentLogin);

                // close this activity
                finish();
            }
        }, 2000);
    }
}
