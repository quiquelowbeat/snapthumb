package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import lombok.ToString;

@ToString
public class Image {

    private String url;
    private String contentType;

    public Image(String url, String contentType) {
        this.url = url;
        this.contentType = contentType;
    }

    public String url() {
        return url;
    }

    public String contentType() {
        return contentType;
    }

}
