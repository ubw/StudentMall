package com.cjwstorm.service.ex;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException() {
    }

    public AddressNotFoundException(String message) {
        super(message);
    }
}
