package com.snapthumb.thumbnailgenerator.user_management.domain.exceptions;

public class CantSaveUser extends RuntimeException {

    private final String uuid;

    public CantSaveUser(Throwable cause, String uuid) {
        super(cause);
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}