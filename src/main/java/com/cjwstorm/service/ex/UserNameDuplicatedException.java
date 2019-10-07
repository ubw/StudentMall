package com.cjwstorm.service.ex;

public class UserNameDuplicatedException extends RuntimeException{
    public UserNameDuplicatedException() {
    }

    public UserNameDuplicatedException(String message) {
        super(message);
    }
}
