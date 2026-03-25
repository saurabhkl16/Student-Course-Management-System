package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person {

    // Private fields (Encapsulation)
    private String batch;
    private boolean active;

    public Student() {
        super(IdGenerator.getNextStudentId(), "", "", "");
        // this.id = IdGenerator.generateId(); // auto-generate ID
        this.active = true;
    }

    // Default constructor
    public Student(String firstName, String lastName, String email, String batch, boolean active) {
        super(IdGenerator.getNextStudentId(), firstName, lastName, email); // call Person constructor
        this.batch = batch;
        this.active = active;
    }

    // Constructor overloading: without active (default to true)
    public Student(String firstName, String lastName, String email, String batch) {
        this(firstName, lastName, email, batch, true);
    }

    @Override
    public String getDisplayName() {
        return firstName + " " + lastName + " (Student)";
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
