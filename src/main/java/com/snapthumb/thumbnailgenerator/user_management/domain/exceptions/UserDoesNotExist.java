package com.snapthumb.thumbnailgenerator.user_management.domain.exceptions;

public class UserDoesNotExist extends RuntimeException {

    private final String uuid;

    public UserDoesNotExist(String uuid) {
        super();
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}