package com.dolphinevents.userservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND , reason = "user doesn't exists.")
public class UserNotFoundException extends Throwable {

    public UserNotFoundException(String message) {
        super(message);
    }

}
