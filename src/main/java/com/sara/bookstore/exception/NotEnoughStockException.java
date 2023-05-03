package com.sara.bookstore.exception;

import org.springframework.http.HttpStatus;

public class NotEnoughStockException extends RestException{
    public NotEnoughStockException( String errorCode, String errorDescription) {
        super(HttpStatus.BAD_REQUEST, errorCode, errorDescription);
    }
}
