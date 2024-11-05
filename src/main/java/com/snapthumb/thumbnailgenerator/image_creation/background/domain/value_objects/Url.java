package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.net.MalformedURLException;
import java.net.URL;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.exceptions.InvalidUrlArgument;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Url {

    private final String value;

    public Url(String url) {
        this.value = validateUrl(url);
    }

    public String value() {
        return value;
    }

    private String validateUrl(String value) {
        try {
            URL validUrl = new URL(value);
            if (!"http".equalsIgnoreCase(validUrl.getProtocol()) &&
                    !"https".equalsIgnoreCase(validUrl.getProtocol())) {
                throw new InvalidUrlArgument("URL protocol must be HTTP or HTTPS.");
            }
            return validUrl.toString();
        } catch (MalformedURLException e) {
            throw new InvalidUrlArgument("Invalid URL format: " + value);
        }
    }

}
