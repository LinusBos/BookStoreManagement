package org.example;

import java.util.ArrayList;

public class BookLibrary implements Catalog {
    private ArrayList<Book> bookList;
    private ShoppingCart shoppingCart;

    public BookLibrary(ArrayList<Book> bookList, ShoppingCart shoppingCart) {
        this.bookList = bookList;
        this.shoppingCart = shoppingCart;
    }
    @Override
    public ArrayList<Product> searchProduct(){
        return null; // TODO
    }
}
