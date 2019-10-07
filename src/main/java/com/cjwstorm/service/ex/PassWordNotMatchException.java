package com.cjwstorm.service.ex;

public class PassWordNotMatchException extends RuntimeException{
    public PassWordNotMatchException() {
    }

    public PassWordNotMatchException(String message) {
        super(message);
    }
}
