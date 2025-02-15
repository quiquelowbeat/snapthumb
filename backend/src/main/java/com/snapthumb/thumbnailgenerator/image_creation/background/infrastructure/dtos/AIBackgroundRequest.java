package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.Accessors;

@Schema(description = "Request object for creating an AI-generated background image")
@Getter
@Accessors(fluent = true)
public final class AIBackgroundRequest {

    @Schema(description = "Prompt used to generate the AI image", example = "A serene mountain landscape at sunset")
    @JsonProperty("prompt")
    private final String prompt;

    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    @JsonProperty("url")
    private final String url;

    @Schema(description = "Title of the background image", example = "Mountain Sunset")
    @JsonProperty("title")
    private final String title;

    @Schema(description = "Description of the background image", example = "A beautiful mountain landscape with warm sunset colors")
    @JsonProperty("description")
    private final String description;

    @Schema(description = "Timestamp when the image was created in ISO 8601 format", example = "2023-01-01T12:00:00.000000Z")
    @JsonProperty("created_at")
    private final Instant createdAt;

    public AIBackgroundRequest(String prompt, String url, String title, String description, Instant createdAt) {
        this.prompt = prompt;
        this.url = url;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

}
