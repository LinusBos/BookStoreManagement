package org.example;

import java.util.ArrayList;

public class BookLibrary implements Catalog {
    private ArrayList<Book> bookList;
    private ShoppingCart shoppingCart;

    public BookLibrary(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    @Override
    public ArrayList<Product> searchProduct(String title){
        return null; // TODO
    }

    @Override
    public ArrayList<Product> getProducts() {
        return null;
    }
}
