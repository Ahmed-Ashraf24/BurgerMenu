package com.example.burgermenuappjava.Data.Model;

public class MenuItemEntity {

    private String name;
    private double price;
    private String category;
    private boolean available;

    // Required no-arg constructor for Firestore
    public MenuItemEntity() {
        this.name = "";
        this.price = 0.0;
        this.category = "";
        this.available = true;
    }

    public MenuItemEntity(String name, double price, String category, boolean available) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    // Getters and setters (needed for Firebase)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}