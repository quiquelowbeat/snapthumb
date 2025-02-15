package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@Schema(description = "Response object containing uploaded background details")
public final class UploadedBackgroundResponse {
    @JsonProperty("url")
    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    private final String url;

    @JsonProperty("registeredAt")
    @Schema(description = "Timestamp when the image was registered in the system in ISO 8601 format", example = "2023-01-01T12:00:00.000000Z")
    private final Instant registeredAt;

    private UploadedBackgroundResponse(String url, Instant registeredAt) {
        this.url = url;
        this.registeredAt = registeredAt;
    }

    public static UploadedBackgroundResponse createFrom(UploadedBackground uploadedBackground) {
        return new UploadedBackgroundResponse(uploadedBackground.url(), uploadedBackground.registeredAt());
    }
}
