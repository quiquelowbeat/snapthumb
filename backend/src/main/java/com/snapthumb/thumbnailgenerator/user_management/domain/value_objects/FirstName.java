package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import org.apache.commons.lang3.StringUtils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class FirstName {

    private final String value;

    private FirstName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static FirstName create(String firstName) {
        if (StringUtils.isBlank(firstName)) {
            throw new IllegalArgumentException("Name cannot be null, blank or empty.");
        }
        if (firstName.length() > 50) {
            throw new IllegalArgumentException("Name cannot be longer than 50 characters: " + firstName);
        }
        if (!firstName.matches("^[\\p{L}\\s.,'\\-]+$")) {
            throw new IllegalArgumentException("Name contains invalid characters: " + firstName);
        }
        return new FirstName(firstName.trim());
    }
}
