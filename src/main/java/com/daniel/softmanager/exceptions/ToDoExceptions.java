package com.daniel.softmanager.exceptions;

import org.springframework.http.HttpStatus;

public class ToDoExceptions extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public ToDoExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
