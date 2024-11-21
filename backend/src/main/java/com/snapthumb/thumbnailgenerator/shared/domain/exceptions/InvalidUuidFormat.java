package com.snapthumb.thumbnailgenerator.shared.domain.exceptions;

public class InvalidUuidFormat extends RuntimeException {

    private final String uuid;

    public InvalidUuidFormat(String uuid) {
        super(String.format("Invalid UUID format: %s.", uuid));
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }

}
