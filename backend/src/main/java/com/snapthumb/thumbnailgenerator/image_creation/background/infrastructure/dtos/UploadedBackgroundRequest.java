package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@Schema(description = "Request object for uploading a background image")
public final class UploadedBackgroundRequest {

    @JsonProperty("url")
    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    private final String url;

    @JsonProperty("title")
    @Schema(description = "Title of the background image", example = "Mountain Sunset")
    private final String title;

    @JsonProperty("description")
    @Schema(description = "Description of the background image", example = "A beautiful mountain landscape with warm sunset colors")
    private final String description;

    @JsonProperty("uploadedAt")
    @Schema(description = "Timestamp when the image was uploaded in ISO 8601 format", example = "2023-01-01T12:00:00.000000Z")
    private final Instant uploadedAt;

    public UploadedBackgroundRequest(String url, String title, String description, Instant uploadedAt) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.uploadedAt = uploadedAt;
    }

}
