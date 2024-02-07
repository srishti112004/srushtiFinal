package com.example.srushti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R;

import java.util.List;

public class BuyAgainAdapter extends RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder> {

    private Context context;
    private List<BuyAgainItem> buyAgainItemList;

    public BuyAgainAdapter(Context context, List<BuyAgainItem> buyAgainItemList) {
        this.context = context;
        this.buyAgainItemList = buyAgainItemList;
    }

    @NonNull
    @Override
    public BuyAgainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buy_again_item, parent, false);
        return new BuyAgainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAgainViewHolder holder, int position) {
        BuyAgainItem buyAgainItem = buyAgainItemList.get(position);
        holder.foodNameTextView.setText(buyAgainItem.getFoodName());
        holder.priceTextView.setText(String.valueOf(buyAgainItem.getPrice())); // Convert double to string
    }


    @Override
    public int getItemCount() {
        return buyAgainItemList.size();
    }

    static class BuyAgainViewHolder extends RecyclerView.ViewHolder {
        TextView foodNameTextView;
        TextView priceTextView;

        public BuyAgainViewHolder(@NonNull View itemView) {
            super(itemView);
            foodNameTextView = itemView.findViewById(R.id.textView16);
            priceTextView = itemView.findViewById(R.id.textView17);
        }
    }
}
