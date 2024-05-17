package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Product {
    private ArrayList<Author> authors;
    public Book(String title, double sellPrice, double purchasePrice, String releaseDate, ArrayList<Author> authors, int quantity) {
        super(title, sellPrice, purchasePrice, releaseDate, quantity);
        this.authors = authors;
    }
    public ArrayList<Author> getAuthors() {
        return authors;
    }

}
