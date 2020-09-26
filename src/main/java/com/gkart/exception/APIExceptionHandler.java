package com.gkart.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(APIException.class)
    @ResponseBody
    public ResponseEntity<APIException> handleExpection1(APIException ex, WebRequest request){
        System.out.println(" handleExpection1 ");

        return new ResponseEntity(ex.getMessage(), new HttpHeaders(), ex.getStatus());
    }
}
