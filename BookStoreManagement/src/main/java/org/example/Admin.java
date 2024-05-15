package org.example;

public class Admin extends User{
    public Admin(String firstName, String lastName, String password, String phoneNumber, double salary, String username) {
        super(firstName, lastName, password, phoneNumber, salary, username);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
