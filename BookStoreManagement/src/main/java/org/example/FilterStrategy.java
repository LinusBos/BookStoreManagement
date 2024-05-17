package org.example;

import java.util.ArrayList;

public interface FilterStrategy {

    // extract all filtering options
    ArrayList<Product> sort(ArrayList<Product> products);
    // if alphabetic -> something
    // if popularity -> something
    // if price -> something
}
