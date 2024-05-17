package org.example;

import java.util.ArrayList;

public interface Catalog {
    ArrayList<Product> searchProduct(String title);
    ArrayList<Product> getProducts();
    void addProduct(Product product);
    void removeProduct(Product product);
    void updateProduct(Product oldProduct, Product newProduct);
}
