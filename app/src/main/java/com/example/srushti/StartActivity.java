package com.example.srushti;  // Replace com.yourpackage with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.srushti.LoginActivity;
import com.example.srushti.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);  // Assuming your XML file is named activity_start.xml

        // Find the button in your layout
        AppCompatButton nextButton = findViewById(R.id.nextbutton);

        // Set a click listener for the button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start LoginActivity
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);

                // Start the LoginActivity
                startActivity(intent);
            }
            //This is vivek
        });
    }
}
