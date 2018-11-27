package com.kozitski.pufar.exception;

public class PufarValidationException extends RuntimeException{

    public PufarValidationException() {
        super();
    }
    public PufarValidationException(String message) {
        super(message);
    }
    public PufarValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    public PufarValidationException(Throwable cause) {
        super(cause);
    }

}
