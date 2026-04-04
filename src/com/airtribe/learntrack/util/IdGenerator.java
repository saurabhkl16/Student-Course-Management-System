package com.airtribe.learntrack.util;

public class IdGenerator {

    // Static counters
    private static int studentIdCounter = 1000;
    private static int courseIdCounter = 5000;
    private static int enrollmentIdCounter = 1;

    // Private constructor (utility class)
    private IdGenerator() { }

    // Generate Student ID
    public static synchronized int getNextStudentId() {
        return studentIdCounter++;
    }

    // Generate Course ID
    public static synchronized int getNextCourseId() {
        return courseIdCounter++;
    }

    // Generate Enrollment ID
    public static synchronized int getNextEnrollmentId() {
        return enrollmentIdCounter++;
    }
}