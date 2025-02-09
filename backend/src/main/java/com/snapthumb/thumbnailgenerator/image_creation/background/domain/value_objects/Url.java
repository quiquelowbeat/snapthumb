package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.net.MalformedURLException;
import java.net.URL;

import io.micrometer.common.util.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Url {

    private final String value;

    private Url(String url) {
        this.value = url;
    }

    public String value() {
        return value;
    }

    public static Url create(String url) {
        try {
            if (StringUtils.isBlank(url)) {
                throw new IllegalArgumentException("URL cannot be null or empty.");
            }
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
