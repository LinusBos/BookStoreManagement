package org.example;

import java.util.ArrayList;

public interface DataReader {
    void readProducts();
    void readUsers();
    ArrayList<User> getUsers();
    ArrayList<Product> getProducts();
}
