package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

public class UploadedBackgroundRequest {

    private final String url;
    private final String title;
    private final String description;
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
