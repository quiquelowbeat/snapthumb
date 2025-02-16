package com.snapthumb.thumbnailgenerator.user_management.domain;

public class UserNotFound {

    private final String message;

    public UserNotFound(String uuid) {
        this.message = "User with id " + uuid + " not found";
    }

    public String message() {
        return message;
    }

}