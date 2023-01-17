package com.mupra.task.exceptionHandler;

import com.mupra.task.exception.BadFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BadFormatException.class)
    public ResponseEntity<Object> badFormatExceptionHandler(Exception ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
