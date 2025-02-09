package com.snapthumb.thumbnailgenerator.user_management.domain;

public class UserNotFound {

    private final String message;

    public UserNotFound(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}