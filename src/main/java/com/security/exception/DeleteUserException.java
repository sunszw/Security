package com.security.exception;

public class DeleteUserException extends BaseException {
    public DeleteUserException() {
        super();
    }

    public DeleteUserException(String message) {
        super(message);
    }

    public DeleteUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteUserException(Throwable cause) {
        super(cause);
    }

    protected DeleteUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
