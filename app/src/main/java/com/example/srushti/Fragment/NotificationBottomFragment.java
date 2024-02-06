package com.example.srushti.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R; // Change this to the correct package name
import com.example.srushti.adapter.NotificationAdapter;
import com.example.srushti.adapter.NotificationItem;

import java.util.ArrayList;
import java.util.List;

public class NotificationBottomFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private List<NotificationItem> notificationItems;

    public NotificationBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification__bottom_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.menuRecyclerView);
        notificationItems = generateSampleNotificationItems(); // Replace this with your data

        notificationAdapter = new NotificationAdapter(notificationItems, requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(notificationAdapter);
    }

    private List<NotificationItem> generateSampleNotificationItems() {
        List<NotificationItem> itemList = new ArrayList<>();
        itemList.add(new NotificationItem(R.drawable.congrats, "your order has been canceled successfully"));
        itemList.add(new NotificationItem(R.drawable.congrats, "order has been taken by the driver"));
        itemList.add(new NotificationItem(R.drawable.congrats, "congrats your order placed"));
        // Add more items as needed
        return itemList;
    }
}
