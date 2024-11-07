package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.CreationDate;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Description;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Prompt;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.RegistrationDate;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Title;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Url;

public class AIBackground {

    private final UUID uuid;
    private final Url url;
    private final Prompt prompt;
    private final Title title;
    private final Description description;
    private final CreationDate createdAt;
    private final RegistrationDate registeredAt;

    private AIBackground(UUID uuid, String url, String prompt, String title, String description,
            LocalDateTime createdAt, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.url = new Url(url);
        this.prompt = new Prompt(prompt);
        this.title = new Title(title);
        this.description = new Description(description);
        this.createdAt = new CreationDate(createdAt);
        this.registeredAt = new RegistrationDate(registeredAt);
    }

    public static AIBackground createFromPrimitives(UUID uuid, String url, String prompt, String title,
            String description, LocalDateTime createdAt) {
        return new AIBackground(uuid, url, prompt, title, description, createdAt, LocalDateTime.now());
    }

    public static AIBackground createFromPrimitivesWithRegisteredAt(UUID uuid, String url, String prompt, String title,
            String description, LocalDateTime createdAt, LocalDateTime registeredAt) {
        return new AIBackground(uuid, url, prompt, title, description, createdAt, registeredAt);
    }

    public UUID uuid() {
        return uuid;
    }

    public String stringUuid() {
        return uuid.toString();
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
