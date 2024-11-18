package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@Schema(description = "Response object containing uploaded background details")
public class UploadedBackgroundResponse {
    @JsonProperty("url")
    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    private final String url;

    @JsonProperty("registeredAt")
    @Schema(description = "Timestamp when the image was registered in the system", example = "2023-01-01T12:00:00")
    private final LocalDateTime registeredAt;

    private UploadedBackgroundResponse(String url, LocalDateTime registeredAt) {
        this.url = url;
        this.registeredAt = registeredAt;
    }

    public static UploadedBackgroundResponse create(UploadedBackground uploadedBackground) {
        return new UploadedBackgroundResponse(uploadedBackground.url(), uploadedBackground.registeredAt());
    }
}
