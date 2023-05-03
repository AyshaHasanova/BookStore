package com.sara.bookstore.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final ApiError apiError;

    RestException(HttpStatus httpStatus, ApiError apiError) {
        this.httpStatus = httpStatus;
        this.apiError = apiError;
    }

    public RestException(HttpStatus httpStatus, String errorCode, String errorDescription) {
        this(httpStatus, new ApiError(errorCode, errorDescription));
    }
}
