package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

public class AIBackgroundRequest {

    private String url;
    private String prompt;
    private String title;
    private String description;

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

}
