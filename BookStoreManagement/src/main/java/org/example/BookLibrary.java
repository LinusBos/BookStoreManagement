package org.example;

import java.util.ArrayList;

public class BookLibrary implements Catalog {
    private ArrayList<Product> bookList;

    public BookLibrary(ArrayList<Product> bookList) {
        this.bookList = bookList;
    }
    @Override
    public ArrayList<Product> searchProduct(String title){
        return null; // TODO not implemented yet
    }

    @Override
    public ArrayList<Product> getProducts() {
        return bookList;
    }

    @Override
    public void addProduct(Product product) {
        bookList.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        bookList.remove(product);
    }

    @Override
    public void updateProduct(Product oldProduct, Product newProduct) {
        int index = bookList.indexOf(oldProduct);
        if (index >= 0) {
            bookList.set(index, newProduct);
        }
    }


}
