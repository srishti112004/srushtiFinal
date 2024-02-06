package com.example.srushti.adapter;

public class NotificationItem {
    private int imageResource;
    private String notificationText;

    public NotificationItem(int imageResource, String notificationText) {
        this.imageResource = imageResource;
        this.notificationText = notificationText;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getNotificationText() {
        return notificationText;
    }
}
