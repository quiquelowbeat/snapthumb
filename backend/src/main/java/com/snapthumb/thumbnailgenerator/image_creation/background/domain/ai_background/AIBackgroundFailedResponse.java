package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

public class AIBackgroundFailedResponse extends RuntimeException {

    public AIBackgroundFailedResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public AIBackgroundFailedResponse(String message) {
        super(message);
    }

}
