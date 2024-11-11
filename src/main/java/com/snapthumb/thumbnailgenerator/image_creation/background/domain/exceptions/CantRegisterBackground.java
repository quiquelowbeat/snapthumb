package com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions;

public class CantRegisterBackground extends RuntimeException {

    private final String uuid;

    public CantRegisterBackground(String uuid, Throwable cause) {
        super(String.format("Can't save background with UUID: %s.", uuid), cause);
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}
