package com.example.boardsideproject.advice;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgument(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> bindException(BindException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> emptyResultDataAccessException(EmptyResultDataAccessException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
