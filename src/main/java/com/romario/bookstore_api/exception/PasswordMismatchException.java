package com.romario.bookstore_api.exception;

public class PasswordMismatchException extends RuntimeException{

    public PasswordMismatchException(){
        super("Passwords do not match");
    }
}