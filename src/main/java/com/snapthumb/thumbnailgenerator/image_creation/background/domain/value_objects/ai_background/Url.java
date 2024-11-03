package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background;

import java.net.MalformedURLException;
import java.net.URL;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.exceptions.InvalidUrlArgument;

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
            throw new InvalidUrlArgument("Invalid URL format.");
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Url other = (Url) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
