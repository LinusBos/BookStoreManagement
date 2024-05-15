package org.example;

public class Store {
    private Cart cart;
    private Catalog catalog;
    private User user;
    public Store (Cart cart, Catalog catalog, User user) {
        this.cart = cart;
        this.catalog = catalog;
        this.user = user;
    }
}
