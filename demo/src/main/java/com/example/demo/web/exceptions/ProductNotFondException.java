package com.example.demo.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFondException extends RuntimeException {
    public ProductNotFondException(String s) {
        super(s);
    }
}
