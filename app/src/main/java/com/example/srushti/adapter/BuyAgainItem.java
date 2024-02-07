package com.example.srushti.adapter;

public class BuyAgainItem {
    private String foodName;
    private String price;

    public BuyAgainItem(String foodName, String price) {
        this.foodName = foodName;
        this.price = price;
    }

    // Getters and setters
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
