package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Response object containing AI-generated background details")
public class AIBackgroundResponse {

    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    private final String url;

    @Schema(description = "Timestamp when the image was registered in the system", example = "2023-01-01T12:00:00")
    private final LocalDateTime registeredAt;

    private AIBackgroundResponse(String url, LocalDateTime registeredAt) {
        this.url = url;
        this.registeredAt = registeredAt;
    }

    public static AIBackgroundResponse create(AIBackground aiBackground) {
        return new AIBackgroundResponse(aiBackground.url(), aiBackground.registeredAt());
    }

}
