package com.airtribe.learntrack.entity;

public class Person {

    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;

    // Constructor
    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Method to display name (can be overridden)
    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    // Optional: display info
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + getDisplayName() + ", Email: " + email);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
