package com.sara.bookstore.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ApiError> handleRestException(RestException restException) {
        System.out.println(restException.getApiError().getMessage());
        return ResponseEntity.status(restException.getHttpStatus()).body(restException.getApiError());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ObjectError error = ex.getBindingResult().getAllErrors().stream().findAny().orElse(null);
        FieldError fieldError = (FieldError) error;
        String errorMessage = String.format("%s", Objects.requireNonNull(fieldError).getDefaultMessage());
        ApiError errorResponse = new ApiError(HttpStatus.BAD_REQUEST.name(), errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> globalExceptionHandler(Exception ex, WebRequest request) {
        ApiError message = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
    }

}
