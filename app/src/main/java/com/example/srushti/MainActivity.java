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

    private AppBarConfiguration appBarConfiguration;
    private NotificationBottomFragment notificationBottomFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView notificationIcon = findViewById(R.id.imageView2);

        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView2);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.cartFragment, R.id.searchFragment, R.id.historyFragment, R.id.profileFragment)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        notificationBottomFragment = (NotificationBottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        notificationIcon = findViewById(R.id.imageView2);
        notificationIcon.setOnClickListener(view -> {
            // Check if NotificationBottomFragment is present
            if (notificationBottomFragment != null) {
                // Show the NotificationBottomFragment
                navController.navigate(R.id.bottomNavigationView);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
