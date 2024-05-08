package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Product{

    private ArrayList<Author> authors;
    public Book(String title, double price, Date releaseDate, ArrayList<Author> authors) {
        super(title, price, releaseDate);
        this.authors = authors;
    }
    public ArrayList<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }
}
