package com.example.srushti;  // Replace com.yourpackage with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.srushti.LoginActivity;
import com.example.srushti.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);  // Assuming your XML file is named activity_signup.xml

        // Find the button in your layout
        AppCompatButton createAccountButton = findViewById(R.id.button3);
        TextView sign=findViewById(R.id.textView9);

        // Set a click listener for the button
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start LoginActivity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);

                // Start the LoginActivity
                startActivity(intent);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);

                // Start the LoginActivity
                startActivity(intent);
            }
        });
    }
}
