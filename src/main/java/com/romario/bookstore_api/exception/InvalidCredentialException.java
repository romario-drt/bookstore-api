package com.romario.bookstore_api.exception;

public class InvalidCredentialException extends RuntimeException {

    private static final String defaultMessage = "email or password invalid";

    public InvalidCredentialException(){
        super(defaultMessage);
    }

}
