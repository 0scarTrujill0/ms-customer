package com.oscartrujillo.mscustomer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
  public ResponseEntity<GlobalResponse<String>> handleHttpMessageNotReadableException(
      org.springframework.http.converter.HttpMessageNotReadableException ex) {
    GlobalResponse<String> response = new GlobalResponse<>(HttpStatus.BAD_REQUEST.value(), false, ex.getMessage(), null);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
