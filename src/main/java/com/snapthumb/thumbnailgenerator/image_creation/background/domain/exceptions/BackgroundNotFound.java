package com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions;

public class BackgroundNotFound extends RuntimeException {

    private final String uuid;

    public BackgroundNotFound(String uuid) {
        super();
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}
