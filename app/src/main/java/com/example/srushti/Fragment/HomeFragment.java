package com.example.srushti.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;
import com.example.srushti.adapter.PopularAdapter;
import com.example.srushti.adapter.popularItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imgColl = view.findViewById(R.id.Imgcoll); // Find the ImageView by its ID
        recyclerViewPopular = view.findViewById(R.id.recyclerView);
        TextView viewMenuTextView = view.findViewById(R.id.textView14);

        // Initialize RecyclerView and its adapter
        popularItemList = new ArrayList<>();
        popularAdapter = new PopularAdapter(popularItemList, requireContext());
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewPopular.setAdapter(popularAdapter);

        // Retrieve data from Firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("popularItems");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                popularItemList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    popularItem item = snapshot.getValue(popularItem.class);
                    popularItemList.add(item);
                }
                popularAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        // Start the image change task after the ImageView is properly initialized
        startImageChangeTask();

        viewMenuTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the MenuBottomSheetFragment
                MenuBottomSheetFragment bottomSheetFragment = new MenuBottomSheetFragment();
                bottomSheetFragment.show(getParentFragmentManager(), bottomSheetFragment.getTag());
            }
        });

        return view;
    }


    private void startImageChangeTask() {
        handler = new Handler();
        Runnable imageChangeRunnable = new Runnable() {
            @Override
            public void run() {
                // Change the image source
                imgColl.setImageResource(imageResources[currentImageIndex]);
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
}
