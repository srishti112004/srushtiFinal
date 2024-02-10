package com.example.srushti;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.srushti.Fragment.NotificationBottomFragment;
import com.example.srushti.adapter.NotificationItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private NotificationBottomFragment notificationBottomFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView notificationIcon = findViewById(R.id.imageView2);

        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView2);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);


        NavigationUI.setupWithNavController(bottomNavigationView, navController);


    }
}
