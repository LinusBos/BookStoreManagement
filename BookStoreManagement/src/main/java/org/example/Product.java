package org.example;

import java.util.Date;

public class Product {
    private String title;
    private double price;
    private Date releaseDate;
    public Product(String title, double price, Date releaseDate) {
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
