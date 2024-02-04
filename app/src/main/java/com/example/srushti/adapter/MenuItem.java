package com.example.srushti.adapter;

public class MenuItem {
    private int imageResource;
    private String foodName;
    private String price;

    public MenuItem(int imageResource, String foodName, String price) {
        this.imageResource = imageResource;
        this.foodName = foodName;
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getPrice() {
        return price;
    }
}
