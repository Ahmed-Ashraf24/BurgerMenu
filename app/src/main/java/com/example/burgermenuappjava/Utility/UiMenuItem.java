package com.example.burgermenuappjava.Utility;


public class UiMenuItem {
    private int id;
    private String name;
    private double price;
    private int imageRes;
    private int quantity;

    public UiMenuItem(int id, String name, double price, int imageRes, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageRes = imageRes;
        this.quantity = quantity;
    }

    // Overloaded constructor with default quantity = 0
    public UiMenuItem(int id, String name, double price, int imageRes) {
        this(id, name, price, imageRes, 0);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageRes() {
        return imageRes;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}