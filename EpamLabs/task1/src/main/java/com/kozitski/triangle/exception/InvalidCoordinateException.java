package com.kozitski.triangle.exception;

public class InvalidCoordinateException extends Exception {
    public InvalidCoordinateException() {
        super();
    }
    public InvalidCoordinateException(String message) {
        super(message);
    }
    public InvalidCoordinateException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidCoordinateException(Throwable cause) {
        super(cause);
    }
    protected InvalidCoordinateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
