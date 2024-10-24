package com.snapthumb.thumbnailgenerator.user_management.domain.exceptions;

public class UserNotFound extends RuntimeException {

    private final String uuid;

    public UserNotFound(String uuid) {
        super();
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}