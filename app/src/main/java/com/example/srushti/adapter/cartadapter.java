package com.example.srushti.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class cartadapter extends RecyclerView.Adapter<cartadapter.CartViewHolder> {

    private List<popularItem> cartItemList;
    private Context context;
    private DatabaseReference mDatabase;

    public cartadapter(List<popularItem> cartItemList, Context context) {
        this.cartItemList = cartItemList;
        this.context = context;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("cartItems");
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        popularItem currentItem = cartItemList.get(position);

        // Set data to views
        holder.cartImage.setImageResource(currentItem.getImageResource());
        holder.cartFoodName.setText(currentItem.getFoodName());
        holder.cartItemPrice.setText(currentItem.getPrice());
        holder.quantityTextView.setText(String.valueOf(currentItem.getQuantity()));

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment quantity
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    popularItem currentItem = cartItemList.get(adapterPosition);
                    currentItem.setQuantity(currentItem.getQuantity() + 1);
                    notifyItemChanged(adapterPosition);
                    updateCartItem(currentItem);
                }
            }
        });

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Decrement quantity
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    popularItem currentItem = cartItemList.get(adapterPosition);
                    int quantity = currentItem.getQuantity();
                    if (quantity > 1) {
                        currentItem.setQuantity(quantity - 1);
                        notifyItemChanged(adapterPosition);
                        updateCartItem(currentItem);
                    } else {
                        Toast.makeText(context, "Minimum quantity reached", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete item
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    popularItem currentItem = cartItemList.get(adapterPosition);
                    cartItemList.remove(adapterPosition);
                    notifyItemRemoved(adapterPosition);
                    deleteCartItem(currentItem);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    private void updateCartItem(popularItem item) {
        // Update item in Firebase database
        mDatabase.child(item.getFoodName()).setValue(item);
    }

    private void deleteCartItem(popularItem item) {
        // Delete item from Firebase database
        mDatabase.child(item.getFoodName()).removeValue();
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