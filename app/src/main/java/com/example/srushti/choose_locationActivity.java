package com.example.srushti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class choose_locationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start StartActivityActivity
                Intent intent = new Intent(choose_locationActivity.this, MainActivity.class);

                // Start the StartActivityActivity
                startActivity(intent);

                // Finish the current activity to prevent going back to SplashActivity
                finish();
            }
        }, 3000);
    }
}