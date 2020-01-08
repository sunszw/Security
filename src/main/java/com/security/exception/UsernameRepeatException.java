package com.security.exception;

public class UsernameRepeatException extends BaseException {
    public UsernameRepeatException() {
        super();
    }

    public UsernameRepeatException(String message) {
        super(message);
    }

    public UsernameRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameRepeatException(Throwable cause) {
        super(cause);
    }

    protected UsernameRepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
