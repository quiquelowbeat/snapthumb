package com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions;

public class AIBackgroundFailedResponse extends RuntimeException {

    public AIBackgroundFailedResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public AIBackgroundFailedResponse(String message) {
        super(message);
    }

}
