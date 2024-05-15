package org.example;

import java.util.Date;

public class Product {
    private String title;
    private double salePrice;
    private double purchasePrice;
    private String releaseDate;
    private int quantity;
    public Product(String title, double salePrice, double purchasePrice, String releaseDate, int quantity) {
        this.title = title;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setTitle(String title) {
        this.title = title;
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
