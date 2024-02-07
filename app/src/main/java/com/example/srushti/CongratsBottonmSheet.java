package com.example.srushti;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CongratsBottonmSheet extends BottomSheetDialogFragment {

    private PayOutActivity onGoHomeClickListener;
    private LayoutInflater inflater;
    @Nullable
    private ViewGroup container;
    @Nullable
    private Bundle savedInstanceState;

    public static CongratsBottonmSheet newInstance() {
        return new CongratsBottonmSheet();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
        View view = inflater.inflate(R.layout.fragment_congrats_bottonm_sheet, container, false);

        // Your fragment initialization code

        Button goHomeButton = view.findViewById(R.id.button6);
        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                // Start the activity
                startActivity(intent);
            }
        });

        return view;
    }

    public void setOnGoHomeClickListener(PayOutActivity listener) {
        this.onGoHomeClickListener = listener;
    }
}
