package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;

import lombok.Getter;

@Getter
public class UploadedBackgroundResponse {
    private final String url;
    private final LocalDateTime registeredAt;

    private UploadedBackgroundResponse(String url, LocalDateTime registeredAt) {
        this.url = url;
        this.registeredAt = registeredAt;
    }

    public static UploadedBackgroundResponse create(UploadedBackground uploadedBackground) {
        return new UploadedBackgroundResponse(uploadedBackground.url(), uploadedBackground.registeredAt());
    }
}
