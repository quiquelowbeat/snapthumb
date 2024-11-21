package com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions;

public class CantGenerateAIBackground extends RuntimeException {

    public CantGenerateAIBackground(Throwable cause) {
        super("Failed to generate AI background.", cause);
    }

}
