package com.example.srushti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PayOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_out);

        CongratsBottonmSheet bottomSheetFragment = CongratsBottonmSheet.newInstance();
        bottomSheetFragment.setOnGoHomeClickListener(this);
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());


        abstract class OnGoHomeClickListener {
            public abstract void onGoHomeClicked();
        }

    }
    public void onGoHomeClicked() {

        Intent intent = new Intent(this, CongratsBottonmSheet.class);
        startActivity(intent);
        finish(); // Optional: finish the current activity if needed
    }
}