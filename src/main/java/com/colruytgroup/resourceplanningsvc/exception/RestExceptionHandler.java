package com.colruytgroup.resourceplanningsvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;


@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex){
        AppError appError = new AppError(HttpStatus.NOT_FOUND,ex.getMessage());
        return new ResponseEntity<>(appError,HttpStatus.NOT_FOUND);
    }

}
