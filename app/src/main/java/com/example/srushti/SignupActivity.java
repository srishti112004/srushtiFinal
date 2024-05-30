package com.example.srushti;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, MainActivity.class));
                finish();
            }
        });
        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) binding.name).getText().toString();

                String email =((EditText) binding.email).getText().toString();
                String password =((EditText) binding.password).getText().toString();
                createAccount(name, email, password);
            }
        });
    }

    private void createAccount(String name, String email, String password) {
        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("creating");
        progressDialog.setMessage("Account");
        progressDialog.show();
        fAuth.createUserWithEmailAndPassword(email.trim(), password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name).build();
                        FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileChangeRequest);
                        progressDialog.cancel();
                        Toast.makeText(SignupActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                        ((EditText) binding.name).setText("");
                        ((EditText)binding.email).setText("");
                        ((EditText)binding.password).setText("");


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.cancel();
                        Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

