package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

public class BackgroundNotFound {

    private final String message;

    public BackgroundNotFound(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
