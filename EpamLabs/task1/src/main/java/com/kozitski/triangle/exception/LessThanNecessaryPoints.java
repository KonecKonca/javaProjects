package com.kozitski.triangle.exception;

public class LessThanNecessaryPoints extends RuntimeException {
    public LessThanNecessaryPoints() {
        super();
    }
    public LessThanNecessaryPoints(String message) {
        super(message);
    }
    public LessThanNecessaryPoints(String message, Throwable cause) {
        super(message, cause);
    }
    public LessThanNecessaryPoints(Throwable cause) {
        super(cause);
    }
    protected LessThanNecessaryPoints(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
