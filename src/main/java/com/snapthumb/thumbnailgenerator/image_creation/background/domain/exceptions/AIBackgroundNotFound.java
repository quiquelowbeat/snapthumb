package com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions;

public class AIBackgroundNotFound extends RuntimeException {

    private final String uuid;

    public AIBackgroundNotFound(String uuid) {
        super();
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}
