package com.example.srushti;  // Replace com.yourpackage with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000; // Time in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);  // Assuming your XML file is named activity_splash.xml

        // Using a Handler to delay the intent for a specific time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start StartActivityActivity
                Intent intent = new Intent(SplashActivity.this, StartActivity.class);

                // Start the StartActivityActivity
                startActivity(intent);

                // Finish the current activity to prevent going back to SplashActivity
                finish();
            }
        }, 3000);
    }
}
