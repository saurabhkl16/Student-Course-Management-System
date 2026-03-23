package com.airtribe.learntrack.util;

public class IdGenerator {
    // Static counter for IDs (starts from 1000 for example)
    private static int counter = 1000;

    // Private constructor to prevent instantiation
    private IdGenerator() { }

    // Synchronized method to generate unique ID
    public static synchronized int generateId() {
        return counter++;
    }
}