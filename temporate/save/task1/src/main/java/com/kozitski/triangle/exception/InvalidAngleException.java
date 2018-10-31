package com.kozitski.triangle.exception;

public class InvalidAngleException extends InvalidCoordinateException {

    public InvalidAngleException() {
        super();
    }
    public InvalidAngleException(String message) {
        super(message);
    }
    public InvalidAngleException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidAngleException(Throwable cause) {
        super(cause);
    }
    protected InvalidAngleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
