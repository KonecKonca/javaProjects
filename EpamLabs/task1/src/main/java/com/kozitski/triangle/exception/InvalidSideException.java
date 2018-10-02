package com.kozitski.triangle.exception;

public class InvalidSideException extends InvalidCoordinateException{

    public InvalidSideException() {
        super();
    }
    public InvalidSideException(String message) {
        super(message);
    }
    public InvalidSideException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidSideException(Throwable cause) {
        super(cause);
    }
    protected InvalidSideException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
