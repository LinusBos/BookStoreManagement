package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Saver implements DataWriter{
    @Override
    public void saveProducts(ArrayList<Product> products) {
        File file = new File("src/main/resources/books.json");
        if(file.exists()){

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(products);


            try (FileWriter writer = new FileWriter(file)) {
                writer.write(json);
                System.out.println("Data written to the file successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }

        } else {
            // No file found.
            System.out.println("No file found, creating new.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong creating books.json");;
            }
        }

    }

    @Override
    public void saveUsers(ArrayList<User> users) {
        File file = new File("src/main/resources/users.json");
        if(file.exists()){

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);


            try (FileWriter writer = new FileWriter(file)) {
                writer.write(json);
                System.out.println("Data written to the file successfully.");
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
