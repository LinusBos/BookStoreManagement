package org.example;

import java.util.Date;

public class Product {
    private String title;
    private double price;
    private String releaseDate;
    private int quantity;
    public Product(String title, double price, String releaseDate, int quantity) {
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
    }
    public void increaseQuantity(int amount) {
        quantity += amount;
    }
    public void decreaseQuantity(int amount) {
        if(quantity >= amount){
            quantity -= amount;
        } else {
            quantity = 0;
        }

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
