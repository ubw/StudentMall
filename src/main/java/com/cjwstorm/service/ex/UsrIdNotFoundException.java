package com.cjwstorm.service.ex;

public class UsrIdNotFoundException extends RuntimeException{
    public UsrIdNotFoundException() {
    }

    public UsrIdNotFoundException(String message) {
        super(message);
    }
}
