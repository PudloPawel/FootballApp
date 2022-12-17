package com.example.footballapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String explanation) {
        super(explanation);
    }

    public ResourceNotFoundException() {
        super("Resource not found");
    }

}
