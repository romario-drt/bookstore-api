package com.romario.bookstore_api.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){
        super(error);
    }
}
