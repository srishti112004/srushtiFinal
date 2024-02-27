package com.example.srushti;

import android.view.LayoutInflater;
import android.view.View;

public class LoginActivityBinding {
    public View login;
    public View email;
    public View password;
    public View goTosignup;

    public static LoginActivityBinding inflate(LayoutInflater layoutInflater) {
        // Inflate the layout XML file to create the view hierarchy
        View rootView = layoutInflater.inflate(R.layout.activity_login, null);

        // Create an instance of LoginActivityBinding
        LoginActivityBinding binding = new LoginActivityBinding();

        // Assign views from the inflated layout to the corresponding fields in the binding object
        binding.login = rootView.findViewById(R.id.login);
        binding.email = rootView.findViewById(R.id.email);
        binding.password = rootView.findViewById(R.id.password);
        binding.goTosignup = rootView.findViewById(R.id.goTosignup);

        return binding; // Return the LoginActivityBinding instance
    }

    public int getRoot() {
        // Return the root view's ID
        return login.getId();
    }
}
