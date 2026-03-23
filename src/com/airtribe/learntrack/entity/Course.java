package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    // Default constructor
    public Course() {
        System.out.println("Welcome");
        // this.id = IdGenerator.generateId();
        // this.active = true;
    }

    // Parameterized constructor
    public Course(String courseName, String description, int durationInWeeks, boolean active) {
        this.id = IdGenerator.generateId();
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Course{"
                + "id=" + id
                + ", name='" + courseName + '\''
                + ", description='" + description + '\''
                + ", duration=" + durationInWeeks + " weeks"
                + ", active=" + active
                + '}';
    }
}
