package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.DateCreated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.DateRegistered;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.Description;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.Prompt;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.Title;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.Url;

public class AIBackground {

    private final UUID uuid;
    private final Url url;
    private final Prompt prompt;
    private final Title title;
    private final Description description;
    private final DateCreated createdAt;
    private final DateRegistered registeredAt;

    private AIBackground(UUID uuid, String url, String prompt, String title, String description,
            LocalDateTime createdAt, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.url = new Url(url);
        this.prompt = new Prompt(prompt);
        this.title = new Title(title);
        this.description = new Description(description);
        this.createdAt = new DateCreated(createdAt);
        this.registeredAt = new DateRegistered(registeredAt);
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
        return url.value();
    }

    public String prompt() {
        return prompt.value();
    }

    public String title() {
        return title.value();
    }

    public String description() {
        return description.value();
    }

    public LocalDateTime createdAt() {
        return createdAt.value();
    }

    public LocalDateTime registeredAt() {
        return registeredAt.value();
    }

}
