package org.example;

import java.util.ArrayList;

public interface ProductBuilder {
    ProductBuilder setTitle(String title);
    ProductBuilder setPrice(double price);
    ProductBuilder setReleaseDate(String releaseDate);
    ProductBuilder setQuantity(int quantity);
    Product build();
}
