package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;

public class AIBackgroundRequest {

    private final String prompt;
    private final String url;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;

    public AIBackgroundRequest(String prompt,  String url, String title, String description, LocalDateTime createdAt) {
        this.prompt = prompt;
        this.url = url;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String prompt() {
        return prompt;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public String url() {
        return url;
    }

}
