package org.example;

import java.util.ArrayList;

public class BookSorter {
    private FilterStrategy filterStrategy;

    public void setFilterStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }
    public ArrayList<Product> sortBooks(ArrayList<Product> products) {
        if (filterStrategy != null) {
             return filterStrategy.sort(products);
        }
        return products;
    }
}
