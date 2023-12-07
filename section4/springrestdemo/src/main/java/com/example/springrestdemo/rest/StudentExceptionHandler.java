package com.example.springrestdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
        StudentErrorResponse res = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
        StudentErrorResponse res = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
