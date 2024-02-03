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

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private List<popularItem> popularItemList;
    private Context context;

    public PopularAdapter(List<popularItem> popularItemList, Context context) {
        this.popularItemList = popularItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        popularItem popularItem = popularItemList.get(position);

        // Set data to views
        holder.imageView.setImageResource(popularItem.getImageResource());
        holder.foodNameTextView.setText(popularItem.getFoodName());
        holder.priceTextView.setText(popularItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return popularItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView foodNameTextView;
        TextView priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView5);
            foodNameTextView = itemView.findViewById(R.id.foodNamePopular);
            priceTextView = itemView.findViewById(R.id.pricePopular);
        }
    }
}
