package com.airtribe.learntrack.exception;

public class EntityNotFoundException extends RuntimeException {

    // Constructor
    public EntityNotFoundException(String message) {
        super(message);
    }
}