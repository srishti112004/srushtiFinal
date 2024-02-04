
package com.example.srushti.Fragment;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageButton;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.DialogFragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.srushti.R;
        import com.example.srushti.adapter.MenuAdapter;
        import com.example.srushti.adapter.MenuItem;

        import java.util.ArrayList;
        import java.util.List;

public class MenuBottomSheetFragment extends DialogFragment {

    private RecyclerView menuRecyclerView;
    private MenuAdapter menuAdapter;
    private ImageButton btnBack;
    private List<MenuItem> menuItems;

    public MenuBottomSheetFragment() {
        // Required empty public constructor
    }

    // Factory method to create a new instance of the fragment
    public static MenuBottomSheetFragment newInstance() {
        return new MenuBottomSheetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menuRecyclerView = view.findViewById(R.id.menuRecyclerView);
        btnBack= view.findViewById(R.id.buttonBack);

        // Initialize RecyclerView and its adapter
        menuItems = generateSampleMenuItems(); // Replace this with your data
        menuAdapter = new MenuAdapter(menuItems, requireContext());
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        menuRecyclerView.setAdapter(menuAdapter);
    }



    private List<MenuItem> generateSampleMenuItems() {
        List<MenuItem> itemList = new ArrayList<>();
        // Add sample menu items here
        itemList.add(new MenuItem(R.drawable.image1, "Sample Food 1", "$10"));
        itemList.add(new MenuItem(R.drawable.image2, "Sample Food 2", "$8"));
        itemList.add(new MenuItem(R.drawable.image3, "Sample Food 3", "$12"));
        // Add more items as needed
        return itemList;
    }

}