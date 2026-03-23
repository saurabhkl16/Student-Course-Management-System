package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student {

    // Private fields (Encapsulation)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String batch;
    private boolean active;

    public Student() {
        this.id = IdGenerator.generateId(); // auto-generate ID
        this.active = true;
    }

    // Default constructor
    public Student(String firstName, String lastName, String email, String batch, boolean active) {
        this.id = IdGenerator.generateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.batch = batch;
        this.active = active;
    }

    // Constructor overloading: without active (default to true)
    public Student(String firstName, String lastName, String email, String batch) {
        this(firstName, lastName, email, batch, true);
    }

    @Override
    public String toString() {
        return "Student{"
                + "id=" + id
                + ", name='" + firstName + " " + lastName + '\''
                + ", email='" + email + '\''
                + ", batch='" + batch + '\''
                + ", active=" + active
                + '}';
    }
}
