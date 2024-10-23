package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;

public class DTOBackgroundFactory {

    private DTOBackgroundFactory() {
    }

    public static AIBackgroundResponse create(AIBackground aiBackground) {
        return new AIBackgroundResponse(aiBackground.url(), aiBackground.registeredAt());

    }

}
