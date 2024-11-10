package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;

import lombok.Getter;

@Getter
public class AIBackgroundResponse {

    private final String url;
    private final LocalDateTime registeredAt;

    private AIBackgroundResponse(String url, LocalDateTime registeredAt) {
        this.url = url;
        this.registeredAt = registeredAt;
    }

    public static AIBackgroundResponse create(AIBackground aiBackground) {
        return new AIBackgroundResponse(aiBackground.url(), aiBackground.registeredAt());

    }

}
