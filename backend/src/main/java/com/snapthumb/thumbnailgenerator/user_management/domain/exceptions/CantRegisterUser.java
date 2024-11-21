package com.snapthumb.thumbnailgenerator.user_management.domain.exceptions;

public class CantRegisterUser extends RuntimeException {

    private final String uuid;

    public CantRegisterUser(Throwable cause, String uuid) {
        super(cause);
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}