package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Saver implements DataWriter{
    @Override
    public void saveProducts(ArrayList<Product> products) {
        File file = new File("src/main/resources/books.json");
        if (file.exists()) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Create a list to hold the JSON representations of books
            ArrayList<JsonObject> bookJsonObjects = new ArrayList<>();

            for (Product product : products) {
                // Check if the product is an instance of Book
                if (product instanceof Book) {
                    Book book = (Book) product;
                    JsonObject bookJsonObject = new JsonObject();
                    bookJsonObject.addProperty("title", book.getTitle());
                    bookJsonObject.addProperty("sellPrice", book.getSellPrice());
                    bookJsonObject.addProperty("purchasePrice", book.getPurchasePrice());
                    bookJsonObject.addProperty("releaseDate", book.getReleaseDate());
                    JsonArray authorsArray = new JsonArray();
                    for (Author author : book.getAuthors()) {
                        JsonObject authorObject = new JsonObject();
                        authorObject.addProperty("firstName", author.getFirstName());
                        authorObject.addProperty("middleName", author.getMiddleName());
                        authorObject.addProperty("lastName", author.getLastName());
                        authorsArray.add(authorObject);
                    }
                    bookJsonObject.add("authors", authorsArray);
                    bookJsonObject.addProperty("quantity", book.getQuantity());

                    bookJsonObjects.add(bookJsonObject);
                }
            }

            String json = gson.toJson(bookJsonObjects);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(json);
                System.out.println("Products written to the file successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }

        } else {
            // No file found.
            System.out.println("No file found, creating new.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong creating books.json");
            }
        }

    }

    @Override
    public void saveUsers(ArrayList<User> users) {
        File file = new File("src/main/resources/users.json");
        if (file.exists()) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);


            try (FileWriter writer = new FileWriter(file)) {
                writer.write(json);
                System.out.println("Users written to the file successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }
        } else {
            // No file found.
            System.out.println("No file found, creating new.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong creating users.json");;
            }
        }
    }

}
