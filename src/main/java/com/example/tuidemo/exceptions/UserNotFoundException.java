package com.example.tuidemo.exceptions;

import java.io.IOException;

import static java.lang.String.format;

public class UserNotFoundException extends IOException {

    public UserNotFoundException(String name) {
        super(format("user with username '%s' - Not found", name));
    }
}
