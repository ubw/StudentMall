package com.cjwstorm.service.ex;

public class UserNotFoundByNameAndPwdException extends RuntimeException{
    public UserNotFoundByNameAndPwdException() {
    }

    public UserNotFoundByNameAndPwdException(String message) {
        super(message);
    }
}
