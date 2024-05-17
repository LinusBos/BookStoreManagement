package org.example;
public class Product {
    private String title;
    private double sellPrice;
    private double purchasePrice;
    private String releaseDate;
    private int quantity;
    public Product(String title, double sellPrice, double purchasePrice, String releaseDate, int quantity) {
        this.title = title;
        this.sellPrice = sellPrice;
        this.purchasePrice = purchasePrice;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
    }
    public void increaseQuantity(int amount) {
        quantity += amount;
    }
    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            quantity = 0;
        }

    }
    public String getTitle() {
        return title;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
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
