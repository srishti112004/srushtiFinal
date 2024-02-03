package com.example.srushti.adapter;

public class popularItem {
    private int imageResource;
    private String foodName;
    private String price;

    public popularItem(int imageResource, String foodName, String price) {
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
