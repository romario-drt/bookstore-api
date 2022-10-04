package com.romario.bookstore_api.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiError {

    @Getter
    List<String> errors;

    public ApiError(String errorMessage) {
        this.errors = Arrays.asList(errorMessage);
    }

    public ApiError(List<String> errorList) {
        this.errors = errorList;
    }
}
