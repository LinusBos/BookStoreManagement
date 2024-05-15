package org.example;


import java.util.ArrayList;

public class BookBuilder implements ProductBuilder {
    private String title = "";
    private double sellPrice = 0;
    private double purchasePrice = 0;
    private String releaseDate = "";
    private ArrayList<Author> authors = new ArrayList<>();
    private int quantity = 0;


    @Override
    public ProductBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public ProductBuilder setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    @Override
    public ProductBuilder setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
        return null;
    }

    @Override
    public ProductBuilder setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Override
    public ProductBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public BookBuilder setAuthorList(ArrayList<Author> authors) {
        this.authors = authors;
        return this;
    }
    @Override
    public Product build() {
        return new Book(title, sellPrice, purchasePrice, releaseDate, authors, quantity);
    }
}
