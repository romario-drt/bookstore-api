package com.romario.bookstore_api.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String type){
        super(type + " resource does not exist");
    }
}
