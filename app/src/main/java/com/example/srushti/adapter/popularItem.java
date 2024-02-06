package com.example.srushti.adapter;

public class popularItem {
    private int imageResource;
    private String foodName;
    private String price;
    private int quantity;

    public popularItem(int imageResource, String foodName, String price,int quantity) {
        this.imageResource = imageResource;
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
    }
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
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
    }

    public void decrementQuantity() {
    }
}
