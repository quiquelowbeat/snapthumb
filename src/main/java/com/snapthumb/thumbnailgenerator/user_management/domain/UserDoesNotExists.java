package com.snapthumb.thumbnailgenerator.user_management.domain;

public class UserDoesNotExists extends RuntimeException {

    private final String uuid;

    public UserDoesNotExists(String uuid) {
        super();
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}