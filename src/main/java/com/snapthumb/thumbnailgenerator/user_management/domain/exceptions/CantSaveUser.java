package com.snapthumb.thumbnailgenerator.user_management.domain.exceptions;

public class CantSaveUser extends RuntimeException {

    private final String uuid;

    public CantSaveUser(String uuid) {
        super();
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}