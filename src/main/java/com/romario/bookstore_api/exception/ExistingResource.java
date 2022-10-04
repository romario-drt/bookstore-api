package com.romario.bookstore_api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExistingResource extends RuntimeException{

        public ExistingResource(String key, String value){
                super(key + " " + value + " already exists");
        }
}
