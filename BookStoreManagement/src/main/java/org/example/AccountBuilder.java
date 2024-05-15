package org.example;

public interface AccountBuilder {
    AccountBuilder setFirstName(String firstName);
    AccountBuilder setLastName(String lastName);
    AccountBuilder setPassword(String password);
    AccountBuilder setPhoneNumber(String phoneNumber);
    AccountBuilder setUsername(String username);
    AccountBuilder setSalary(double salary);
    User build();
    User buildAdmin();
}
