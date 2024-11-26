package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Url {

    private final String value;

    private Url(String url) {
        this.value = url;
    }

    public String value() {
        return value;
    }

    public static Url create(String url) {
        try {
            URL validUrl = new URL(url);
            if (!"http".equalsIgnoreCase(validUrl.getProtocol()) &&
                    !"https".equalsIgnoreCase(validUrl.getProtocol())) {
                throw new IllegalArgumentException("URL protocol must be HTTP or HTTPS.");
            }
            return new Url(validUrl.toString());
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL format: " + url);
        }
    }

}
