package com.cjwstorm.service.ex;

public class PhoneDuplicatedException extends RuntimeException{
    public PhoneDuplicatedException() {
    }

    public PhoneDuplicatedException(String message) {
        super(message);
    }
}
