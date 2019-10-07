package com.cjwstorm.service.ex;

public class ServiceException extends RuntimeException{
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }
}
