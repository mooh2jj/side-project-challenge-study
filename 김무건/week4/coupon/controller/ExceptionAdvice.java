package com.example.coupon.controller;

import com.example.coupon.dto.response.ErrorResponse;
import com.example.coupon.exception.NotFoundIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(MissingRequestHeaderException.class)
  public ErrorResponse missingRequestHeaderException() {
    return new ErrorResponse("MissingRequestHeaderException");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(NotFoundIdException.class)
  public ErrorResponse notFoundIdException() {
    return new ErrorResponse("Not found id");
  }

}
