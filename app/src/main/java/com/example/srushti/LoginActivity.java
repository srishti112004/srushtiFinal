package com.example.srushti;  // Replace com.yourpackage with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Assuming your XML file is named activity_login.xml

        // Find the button in your layout
        AppCompatButton loginButton = findViewById(R.id.button3);
        TextView sign=findViewById(R.id.textView9);

        // Set a click listener for the button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start ChooseFileActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                // Start the ChooseFileActivity
                startActivity(intent);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);

                // Start the ChooseFileActivity
                startActivity(intent);
            }
        });
    }
}
