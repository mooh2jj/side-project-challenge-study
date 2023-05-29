package com.blog.blogproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controllerExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<?> handleIllegalArgumentException(MissingServletRequestParameterException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("적절한 요청이 아닙니다.");
    }
}
