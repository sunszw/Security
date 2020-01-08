package com.security.exception;

public class FindUserException extends BaseException {
    public FindUserException() {
        super();
    }

    public FindUserException(String message) {
        super(message);
    }

    public FindUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindUserException(Throwable cause) {
        super(cause);
    }

    protected FindUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
