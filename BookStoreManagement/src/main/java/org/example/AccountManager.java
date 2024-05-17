package org.example;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<User> users;
    private User currentUser;

    public AccountManager(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public void addUser(User user) {
        users.add(user);
    }

    public boolean login(String username, String password) {
        User temp = new UserBuilder().setUsername(username).setPassword(password).build();
        for (User user: users) {
            if (user.equals(temp)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
