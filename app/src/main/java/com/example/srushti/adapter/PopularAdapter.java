package com.example.srushti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private List<popularItem> popularItemList;
    private Context context;

    public PopularAdapter(List<popularItem> cartItemList, Context context) {
        this.popularItemList = cartItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        popularItem cartItem = popularItemList.get(position);

        // Set data to views
        holder.imageView.setImageResource(cartItem.getImageResource());
        holder.foodNameTextView.setText(cartItem.getFoodName());
        holder.priceTextView.setText(cartItem.getPrice());

        // Set click listener for Add To Cart button
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement your add to cart functionality here
                Toast.makeText(context, "Added to cart: " + cartItem.getFoodName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView foodNameTextView;
        TextView priceTextView;
        TextView addToCartButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cartimage);
            foodNameTextView = itemView.findViewById(R.id.foodNamePopular);
            priceTextView = itemView.findViewById(R.id.pricePopular);
            addToCartButton = itemView.findViewById(R.id.addToCartPopular);
        }
    }
}




