package org.example;

import java.util.ArrayList;

public class BookLibrary implements Catalog {
    private ArrayList<Product> bookList;

    public BookLibrary(ArrayList<Product> bookList) {
        this.bookList = bookList;
    }
    @Override
    public ArrayList<Product> searchProduct(String title){
        return null; // TODO
    }

    @Override
    public ArrayList<Product> getProducts() {
        return bookList;
    }

    @Override
    public void addProduct(Product product) {
        bookList.add(product);
    }


}
