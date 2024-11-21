package com.snapthumb.thumbnailgenerator.user_management.domain.exceptions;

public class UserNotFound extends RuntimeException {

    private final String uuid;

    public UserNotFound(String uuid) {
        super(String.format("User not found with UUID: %s.", uuid));
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}