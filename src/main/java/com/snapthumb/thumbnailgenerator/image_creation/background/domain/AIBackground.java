package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class AIBackground {

    private final UUID uuid;
    private final String url;
    private final String prompt;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime registeredAt;

    private AIBackground(UUID uuid, String url, String prompt, String title, String description,
            LocalDateTime createdAt, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.url = url;
        this.prompt = prompt;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.registeredAt = registeredAt;
    }

    public static AIBackground create(UUID uuid, String url, String prompt, String title, String description,
            LocalDateTime createdAt) {
        return new AIBackground(uuid, url, prompt, title, description, createdAt, LocalDateTime.now());
    }

    public static AIBackground createWithRegisteredAt(UUID uuid, String url, String prompt, String title,
            String description, LocalDateTime createdAt, LocalDateTime registeredAt) {
        return new AIBackground(uuid, url, prompt, title, description, createdAt, registeredAt);
    }

    public UUID uuid() {
        return uuid;
    }

    public String url() {
        return url;
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

    public LocalDateTime registeredAt() {
        return registeredAt;
    }

}
