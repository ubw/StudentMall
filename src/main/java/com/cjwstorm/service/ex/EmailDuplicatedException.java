package com.cjwstorm.service.ex;

public class EmailDuplicatedException extends RuntimeException{
    public EmailDuplicatedException() {
    }

    public EmailDuplicatedException(String message) {
        super(message);
    }
}
