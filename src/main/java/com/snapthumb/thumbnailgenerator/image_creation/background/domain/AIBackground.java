package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AIBackground implements Background {

    @Id
    private UUID uuid;
    private String url;
    private String prompt;
    private String title;
    private String description;

    public AIBackground(UUID uuid, String url, String prompt, String title, String description) {
        this.uuid = uuid;
        this.url = url;
        this.prompt = prompt;
        this.title = title;
        this.description = description;
    }

    @Override
    public UUID uuid() {
        return uuid;
    }

    public String url() {
        return url;
    }

    public String prompt() {
        return prompt;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public boolean isGeneratedByAI() {
        return true;
    }

}
