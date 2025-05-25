package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import java.time.Instant;
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

    private AIBackground(UUID uuid, Url url, Prompt prompt, Title title, Description description,
            CreationDate createdAt, RegistrationDate registeredAt) {
        this.uuid = uuid;
        this.url = url;
        this.prompt = prompt;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.registeredAt = registeredAt;
    }

    public static AIBackground createFromPrimitives(String uuid, String url, String prompt, String title,
            String description, Instant createdAt) {
        return createAIBackground(uuid, url, prompt, title, description, createdAt, Instant.now());
    }

    public static AIBackground createFromPrimitivesWithRegisteredAt(String uuid, String url, String prompt,
            String title,
            String description, Instant createdAt, Instant registeredAt) {
        return createAIBackground(uuid, url, prompt, title, description, createdAt, registeredAt);
    }

    private static AIBackground createAIBackground(String uuid, String url, String prompt, String title,
            String description,
            Instant createdAt, Instant registeredAt) {
        return new AIBackground(
                UUID.fromString(uuid),
                Url.create(url),
                Prompt.create(prompt),
                Title.create(title),
                Description.create(description),
                CreationDate.create(createdAt),
                RegistrationDate.create(registeredAt));
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

    public Instant createdAt() {
        return createdAt.value();
    }

    public Instant registeredAt() {
        return registeredAt.value();
    }

}
