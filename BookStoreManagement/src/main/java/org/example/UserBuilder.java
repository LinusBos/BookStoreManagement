package org.example;

public class UserBuilder implements AccountBuilder {
    private String firstName = "";
    private String lastName = "";
    private String username = "";
    private String password = "";
    private String phoneNumber = "";
    private double salary = 0;



    @Override
    public AccountBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public AccountBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public AccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public AccountBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public AccountBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public AccountBuilder setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public User build() {
        return new User(firstName, lastName, password, phoneNumber, salary, username, false);
    }

    @Override
    public User buildAdmin() {
        return new User(firstName, lastName, password, phoneNumber, salary, username, true);
    }
}
