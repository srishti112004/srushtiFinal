package com.example.srushti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PayOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pay_out );
        Button btn = findViewById( R.id.placeorder );
        CongratsBottonmSheet bottomSheetFragment = CongratsBottonmSheet.newInstance();
        bottomSheetFragment.setOnGoHomeClickListener( this );
        bottomSheetFragment.show( getSupportFragmentManager(), bottomSheetFragment.getTag() );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongratsBottonmSheet bottomSheetFragment = CongratsBottonmSheet.newInstance();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
            }
        } );


    }
}