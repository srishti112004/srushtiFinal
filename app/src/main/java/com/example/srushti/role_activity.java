package com.example.srushti;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

public class role_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        //Getting the userid of the user from gMail to store the user details under this id
        String userId = "abc@gmail.com";
        String encodedUserId = Base64.encodeToString(userId.getBytes(), Base64.NO_WRAP);


        Button userButton = findViewById(R.id.userButton);
        Button adminButton = findViewById(R.id.adminButton);

        //Implementing on clickListener to save the current users role
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity to prevent going back to it
                
            }
        });

        //Implementing on clickListener to save the current admin role
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), adminActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity to prevent going back to it

            }
        });

    }
}
