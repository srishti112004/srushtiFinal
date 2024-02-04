package com.example.srushti.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.srushti.R; // Change this to the correct package name
import com.example.srushti.adapter.MenuAdapter;
import com.example.srushti.adapter.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private SearchView searchView;
    private RecyclerView recyclerView;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuItems;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchView = view.findViewById(R.id.searchView);
        recyclerView = view.findViewById(R.id.menuRecyclerView);

        // Initialize RecyclerView and its adapter
        menuItems = generateSampleMenuItems(); // Replace this with your data
        menuAdapter = new MenuAdapter(menuItems, requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(menuAdapter);

        // Set up the SearchView
        setupSearchView();

        return view;
    }

    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the search query submission (e.g., perform search)
                // You can filter your data based on the query here
                filterMenuItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle the search query as the user types
                // You can filter your data based on the newText here
                filterMenuItems(newText);
                return true;
            }
        });
    }

    private void filterMenuItems(String query) {
        // Implement your filtering logic here
        // Update the RecyclerView adapter with the filtered data
        List<MenuItem> filteredList = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getFoodName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        menuAdapter.setMenuItems(filteredList);
        menuAdapter.notifyDataSetChanged();
    }

    private List<MenuItem> generateSampleMenuItems() {
        // Replace this with your actual data retrieval logic
        // This is just an example
        List<MenuItem> itemList = new ArrayList<>();
        itemList.add(new MenuItem(R.drawable.image1, "Sample Food 1", "$10"));
        itemList.add(new MenuItem(R.drawable.image2, "Sample Food 2", "$8"));
        itemList.add(new MenuItem(R.drawable.image3, "Sample Food 3", "$12"));
        return itemList;
    }
}
