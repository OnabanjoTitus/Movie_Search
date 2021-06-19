package com.moviesSearch.web.exceptions;

public class MovieNameCannotBeNullException extends Exception {
    public MovieNameCannotBeNullException() {
    }

    public MovieNameCannotBeNullException(String message) {
        super(message);
    }

    public MovieNameCannotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieNameCannotBeNullException(Throwable cause) {
        super(cause);
    }
}
