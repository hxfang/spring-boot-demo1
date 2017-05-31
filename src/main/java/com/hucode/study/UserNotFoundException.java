package com.hucode.study;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by admin on 2017/5/31.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long userId) {
        super("Couldn't find user '" + userId + "'.");
    }
}

