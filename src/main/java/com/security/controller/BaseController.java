package com.security.controller;


import com.security.exception.*;
import com.security.json.Json;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


public class BaseController {

    public static final Integer SUCCESS = 2000;

    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public Json<Void> handleException(Throwable throwable) {
        Json<Void> json = new Json<>(throwable);
        if (throwable instanceof UsernameRepeatException) {
            json.setState(4000);
        }
        if (throwable instanceof InsertException) {
            json.setState(4001);
        }
        if (throwable instanceof UserNotFoundException) {
            json.setState(4002);
        }
        if (throwable instanceof PasswordNotMatchException) {
            json.setState(4003);
        }
        if (throwable instanceof NotLoggedInException) {
            json.setState(4004);
        }
        if (throwable instanceof DeleteUserException) {
            json.setState(4005);
        }
        if (throwable instanceof FindUserException) {
            json.setState(4006);
        }
        if (throwable instanceof UpdateException) {
            json.setState(4007);
        }


        return json;
    }
}
