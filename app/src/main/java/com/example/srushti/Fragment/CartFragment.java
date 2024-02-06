package com.example.srushti.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;
import com.example.srushti.adapter.cartadapter;
import com.example.srushti.adapter.popularItem;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private TextView cartTitle;
    private RecyclerView recyclerViewCart;
    private Button proceedButton;
    private cartadapter cartAdapter;
    private List<popularItem> cartItemList;
    private RecyclerView.Adapter cartadapter;

    public CartFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        // Initialize views
        cartTitle = view.findViewById(R.id.textView15);
        recyclerViewCart = view.findViewById(R.id.recyclerViewCart);
        proceedButton = view.findViewById(R.id.button6);

        // Set up RecyclerView
        cartItemList = generateSampleCartItems(); // Replace this with your data
        cartAdapter = new cartadapter(cartItemList, requireContext());
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerViewCart.setAdapter(cartAdapter);

        // Set up button click listener (you can implement your logic here)
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click (e.g., proceed with checkout)
            }
        });

        return view;
    }

    private List<popularItem> generateSampleCartItems() {
        List<popularItem> itemList = new ArrayList<>();
        itemList.add(new popularItem(R.drawable.menu1, "Sandwich", "$10",1));
        itemList.add(new popularItem(R.drawable.menu2, "Momo", "$8",1));
        itemList.add(new popularItem(R.drawable.menu3, "Ice-cream", "$12",1));
        itemList.add(new popularItem(R.drawable.menu4, "Soup", "$14",1));
        itemList.add(new popularItem(R.drawable.menu5, "Pasta", "$15",1));
        itemList.add(new popularItem(R.drawable.menu6, "Wrap", "$16",1));
        itemList.add(new popularItem(R.drawable.menu7, "Fruit salad", "$17",1));
        // Populate the list with sample data
        // You may fetch the actual cart items from your data source
        return itemList;
    }
}
