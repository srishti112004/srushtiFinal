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
                String name = ((EditText) binding.adminname).getText().toString();

                String email =((EditText) binding.adminemails).getText().toString();
                String password =((EditText) binding.adminpasswords).getText().toString();
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
                        Toast.makeText(adminsignup.this, "Account Created", Toast.LENGTH_SHORT).show();
                        ((EditText) binding.adminname).setText("");
                        ((EditText)binding.adminemails).setText("");
                        ((EditText)binding.adminpasswords).setText("");


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.cancel();
                        Toast.makeText(adminsignup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
