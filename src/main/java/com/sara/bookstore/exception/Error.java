package com.sara.bookstore.exception;

public interface Error {
    String BOOK_NOT_FOUND_ERROR_CODE="BB404";
    String BOOK_NOT_FOUND_ERROR_MESSAGE = "Book not found";
    String AUTHOR_NOT_FOUND_ERROR_CODE="AU404";
    String AUTHOR_NOT_FOUND_ERROR_MESSAGE = "Author not found";
    String PUBLISHER_NOT_FOUND_ERROR_CODE="PE404";
    String PUBLISHER_NOT_FOUND_ERROR_MESSAGE = "Publisher not found";
    String REVIEW_NOT_FOUND_ERROR_CODE="RE404";
    String REVIEW_NOT_FOUND_ERROR_MESSAGE = "Review not found";
    String NOT_ENOUGH_STOCK_ERROR_CODE="NO404";
    String NOT_ENOUGH_STOCK_ERROR_MESSAGE="there are not enough books in the database";
}
