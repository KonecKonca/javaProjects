package com.kozitski.task2.exception;

public class TextHandleException extends  Exception{

    public TextHandleException() {
        super();
    }
    public TextHandleException(String message) {
        super(message);
    }
    public TextHandleException(String message, Throwable cause) {
        super(message, cause);
    }
    public TextHandleException(Throwable cause) {
        super(cause);
    }
    protected TextHandleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
