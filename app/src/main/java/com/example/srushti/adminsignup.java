package com.example.srushti;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.srushti.databinding.ActivityAdminsignupBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

public class adminsignup extends AppCompatActivity {
    private ActivityAdminsignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_adminsignup);

        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminsignup.this, adminActivity.class));
                finish();
            }
        });

        binding.createaccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.adminname.getText().toString();
                String email = binding.adminemails.getText().toString();
                String password = binding.adminpasswords.getText().toString();
                createAccount(name, email, password);
            }
        });
    }

    private void createAccount(String name, String email, String password) {
        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        fAuth.createUserWithEmailAndPassword(email.trim(), password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name).build();
                        fAuth.getCurrentUser().updateProfile(profileChangeRequest);
                        progressDialog.dismiss();
                        Toast.makeText(adminsignup.this, "Account Created", Toast.LENGTH_SHORT).show();
                        binding.adminname.setText("");
                        binding.adminemails.setText("");
                        binding.adminpasswords.setText("");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(adminsignup.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
