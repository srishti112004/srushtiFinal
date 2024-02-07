package com.example.srushti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {


    private List<MenuItem> menuItems;
    private Context context;

    public MenuAdapter(List<MenuItem> menuItems, Context context) {
        this.menuItems = menuItems;
        this.context = context;

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem currentItem = menuItems.get(position);

        holder.menuImage.setImageResource(currentItem.getImageResource());
        holder.menuFoodName.setText(currentItem.getFoodName());
        holder.menuPrice.setText(currentItem.getPrice());



        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public void setMenuItems(List<MenuItem> filteredList) {
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView menuImage;
        TextView menuFoodName;
        TextView menuPrice;
        TextView addToCartButton; // Assuming this is a TextView for simplicity

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            menuImage = itemView.findViewById(R.id.menuimage);
            menuFoodName = itemView.findViewById(R.id.menufoodName);
            menuPrice = itemView.findViewById(R.id.menuprice);
            addToCartButton = itemView.findViewById(R.id.addToCartPopular);
        }
    }
}
