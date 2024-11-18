package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request object for uploading a background image")
public class UploadedBackgroundRequest {

    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    private final String url;

    @Schema(description = "Title of the background image", example = "Mountain Sunset") 
    private final String title;

    @Schema(description = "Description of the background image", example = "A beautiful mountain landscape with warm sunset colors")
    private final String description;

    @Schema(description = "Timestamp when the image was uploaded", example = "2023-01-01T12:00:00")
    private final LocalDateTime uploadedAt;

    public UploadedBackgroundRequest(String url, String title, String description, LocalDateTime uploadedAt) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.uploadedAt = uploadedAt;
    }

    public String url() {
        return url;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public LocalDateTime uploadedAt() {
        return uploadedAt;
    }

}
