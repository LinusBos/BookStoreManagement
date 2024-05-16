package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
public class Loader implements DataReader {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    @Override
    public void readProducts() {
        String filePath = "src/main/resources/books.json";
        try {
            // Create a FileReader object to read from the file
            FileReader reader = new FileReader(filePath);

            // Create a Type object representing the ArrayList of Product objects
            Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();

            // Deserialize JSON data into ArrayList of Product objects using Gson
            Gson gson = new Gson();
            ArrayList<Book> books = gson.fromJson(reader, bookListType);

            // Close the reader
            reader.close();

            products = new ArrayList<>(books);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error reading products from JSON file: " + e.getMessage());
        }
    }
    @Override
    public void readUsers() {
        String filePath = "src/main/resources/users.json";
        try {
            // Create a FileReader object to read from the file
            FileReader reader = new FileReader(filePath);

            // Create a Type object representing the ArrayList of Product objects
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();

            // Deserialize JSON data into ArrayList of Product objects using Gson
            Gson gson = new Gson();
            users = gson.fromJson(reader, userListType);

            // Close the reader
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error reading products from JSON file: " + e.getMessage());
        }

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
