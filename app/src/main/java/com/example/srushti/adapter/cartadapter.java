package com.example.srushti.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;

import java.util.List;

public class cartadapter extends RecyclerView.Adapter<cartadapter.CartViewHolder> {

    private List<popularItem> cartItemList;
    private Context context;

    public cartadapter(List<popularItem> cartItemList, Context context) {
        this.cartItemList = cartItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, @SuppressLint("RecyclerView") int position) {
        popularItem currentItem = cartItemList.get(position);

        // Set data to views
        holder.cartImage.setImageResource(currentItem.getImageResource());
        holder.cartFoodName.setText(currentItem.getFoodName());
        holder.cartItemPrice.setText(currentItem.getPrice());
        holder.quantityTextView.setText(String.valueOf(currentItem.getQuantity()));

       /* holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic for incrementing quantity
                // You can update the item quantity in the cartItemList and refresh the adapter
                currentItem.incrementQuantity();
                notifyDataSetChanged();
            }
        });

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic for decrementing quantity
                // You can update the item quantity in the cartItemList and refresh the adapter
                currentItem.decrementQuantity();
                notifyDataSetChanged();
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic for deleting the item from the cart
                // You can remove the item from the list and refresh the adapter
                cartItemList.remove(position);
                notifyDataSetChanged();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView cartImage;
        TextView cartFoodName;
        TextView cartItemPrice;
        TextView quantityTextView;
        ImageButton minusButton;
        ImageButton plusButton;
        ImageButton deleteButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartImage = itemView.findViewById(R.id.cartimage);
            cartFoodName = itemView.findViewById(R.id.cartfoodname);
            cartItemPrice = itemView.findViewById(R.id.cartitemprice);
            quantityTextView = itemView.findViewById(R.id.quantity);
            minusButton = itemView.findViewById(R.id.minusbutton);
            plusButton = itemView.findViewById(R.id.plusbutton);
            deleteButton = itemView.findViewById(R.id.imageButton4);
        }
    }
}
