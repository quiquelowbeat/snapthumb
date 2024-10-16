package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.UUID;

public class UploadedBackground implements Background {

    private UUID uuid;
    private String url;
    private String title;
    private String description;

    public UploadedBackground(UUID uuid, String url, String title, String description) {
        this.uuid = uuid;
        this.url = url;
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
        return false;
    }

}
