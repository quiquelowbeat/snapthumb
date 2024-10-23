package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class AIBackgroundResponse {

    private final String url;
    private final LocalDateTime registeredAt;

    public AIBackgroundResponse(String url, LocalDateTime registeredAt) {
        this.url = url;
        this.registeredAt = registeredAt;
    }

}
