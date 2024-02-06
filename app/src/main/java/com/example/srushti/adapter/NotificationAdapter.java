package com.example.srushti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.srushti.R; // Change this to the correct package name

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<NotificationItem> notificationItems;
    private Context context;

    public NotificationAdapter(List<NotificationItem> notificationItems, Context context) {
        this.notificationItems = notificationItems;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationItem currentItem = notificationItems.get(position);

        holder.notificationImage.setImageResource(currentItem.getImageResource());
        holder.notificationTextView.setText(currentItem.getNotificationText());
    }

    @Override
    public int getItemCount() {
        return notificationItems.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {
        ImageView notificationImage;
        TextView notificationTextView;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationImage = itemView.findViewById(R.id.notificatinImage1);
            notificationTextView = itemView.findViewById(R.id.notificationTextView);
        }
    }
}
