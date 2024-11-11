package com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions;

public class BackgroundNotFound extends RuntimeException {

    private final String uuid;

    public BackgroundNotFound(String uuid) {
        super(String.format("Background not found with UUID: %s.", uuid));
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}
