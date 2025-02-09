package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

public class CantGenerateAIBackground extends RuntimeException {

    public CantGenerateAIBackground(Throwable cause) {
        super("Failed to generate AI background.", cause);
    }

}
