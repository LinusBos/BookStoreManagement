package org.example;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<User> users;

    public AccountManager(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public void addUser(User user) {
        users.add(user);
    }
}
