package com.example.srushti.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;
import com.example.srushti.adapter.PopularAdapter;
import com.example.srushti.adapter.popularItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ImageView imgColl;
    private int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private int currentImageIndex = 0;
    private Handler handler;
    private final int IMAGE_CHANGE_INTERVAL = 3000; // in milliseconds
    private RecyclerView recyclerViewPopular;
    private PopularAdapter popularAdapter;
    private List<popularItem> popularItemList;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imgColl = view.findViewById(R.id.Imgcoll);
        recyclerViewPopular = view.findViewById(R.id.recyclerViewPopular);

        // Initialize RecyclerView and its adapter
        popularItemList = generateSamplePopularItems(); // Replace this with your data
        popularAdapter = new PopularAdapter(popularItemList, requireContext());
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewPopular.setAdapter(popularAdapter);


        // Start the image change task
        startImageChangeTask();

        return view;
    }

    private void startImageChangeTask() {
        handler = new Handler();
        Runnable imageChangeRunnable = new Runnable() {
            @Override
            public void run() {
                // Change the image source
                imgColl.setImageResource(imageResources[currentImageIndex]);

                // Increment the image index or reset to 0 if at the end
                currentImageIndex = (currentImageIndex + 1) % imageResources.length;

                // Schedule the next image change
                handler.postDelayed(this, IMAGE_CHANGE_INTERVAL);
            }
        };

        // Schedule the initial image change
        handler.postDelayed(imageChangeRunnable, IMAGE_CHANGE_INTERVAL);
    }

    @Override
    public void onDestroyView() {
        // Remove callbacks to prevent memory leaks
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroyView();
    }
    private List<popularItem> generateSamplePopularItems() {
        List<popularItem> itemList = new ArrayList<>();
        itemList.add(new popularItem(R.drawable.image1, "Pizza1", "$10"));
        itemList.add(new popularItem(R.drawable.image2, "Pizza2", "$8"));
        itemList.add(new popularItem(R.drawable.image3, "Pizza3", "$12"));
        itemList.add(new popularItem(R.drawable.image3, "Pizza4", "$14"));
        return itemList;
    }

}
