package com.thinh.pas.exceptions;

public class CakeException extends RuntimeException {

    public CakeException() {
    }

    public CakeException(String message) {
        super(message);
    }

    public CakeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CakeException(Throwable cause) {
        super(cause);
    }

    public CakeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
