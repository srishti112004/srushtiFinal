package com.example.srushti.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;
import com.example.srushti.adapter.BuyAgainAdapter;
import com.example.srushti.adapter.BuyAgainItem;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private BuyAgainAdapter adapter;
    private List<BuyAgainItem> historyItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        historyItemList = new ArrayList<>();
        historyItemList.add(new BuyAgainItem("FoodName 1", "$5"));
        historyItemList.add(new BuyAgainItem("FoodName 2", "$10"));
        historyItemList.add(new BuyAgainItem("FoodName 3", "$7"));

        Context context = getContext();
        adapter = new BuyAgainAdapter(context, historyItemList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
