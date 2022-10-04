package com.romario.bookstore_api.exception;

public class ExistingResource extends RuntimeException {

    public ExistingResource(String key, String value) {
        super(key + " " + value + " already exists");
    }
}
