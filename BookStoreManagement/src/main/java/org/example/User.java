package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String username;
    private double salary;
    private boolean admin;

    public User(String firstName, String lastName, String password, String phoneNumber, double salary, String username, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = toHash(password);
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.username = username;
        this.admin = admin;
    }
    public String toHash(String text) {
        return doHashing(text, "SHA256");
    }
    private String doHashing(String text, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(text.getBytes());

            byte[] hashedMessage = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();

            for (byte b: hashedMessage) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(password, user.password) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return admin;
    }
}
