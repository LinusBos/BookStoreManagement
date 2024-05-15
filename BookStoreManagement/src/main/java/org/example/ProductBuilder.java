package org.example;

import java.util.ArrayList;

public interface ProductBuilder {
    ProductBuilder setTitle(String title);
    ProductBuilder setPurchasePrice(double purchasePrice);
    ProductBuilder setSellPrice(double sellPrice);
    ProductBuilder setReleaseDate(String releaseDate);
    ProductBuilder setQuantity(int quantity);
    Product build();
}
