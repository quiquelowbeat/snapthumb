package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.UUID;

public class UploadedBackground {

    private final UUID uuid;
    private final String url;
    private final String title;
    private final String description;

    public UploadedBackground(UUID uuid, String url, String title, String description) {
        this.uuid = uuid;
        this.url = url;
        this.title = title;
        this.description = description;
    }

    public UUID uuid() {
        return uuid;
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

}
