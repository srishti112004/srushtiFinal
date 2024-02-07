package com.example.srushti.adapter;
public class FoodItem {

    private String menufoodName;
    private double price;

    // Constructor
    public FoodItem(String menuFoodName, double price) {
        this.menufoodName = menuFoodName;
        this.price = price;
    }

    // Getter for menuFoodName
    public String getMenuFoodName() {
        return menufoodName;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // You may also have setters if needed
    //last change
}