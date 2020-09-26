package com.gkart.exception;

import org.springframework.http.HttpStatus;

public class APIException extends Exception{

    private String message;
    private HttpStatus status;

    public APIException(String message,HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
