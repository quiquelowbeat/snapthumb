package com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions;

public class CantRegisterBackground extends RuntimeException {

    private final String uuid;

    public CantRegisterBackground(Throwable cause, String uuid) {
        super(cause);
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}
