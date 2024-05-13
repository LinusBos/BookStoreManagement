package org.example;

import java.util.ArrayList;

public interface DataWriter {
    void saveProducts(ArrayList<Product> products);
    void saveUsers(ArrayList<User> user);
}
