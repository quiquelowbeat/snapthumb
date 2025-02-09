package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import org.apache.commons.lang3.StringUtils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class LastName {

    private final String value;

    private LastName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static LastName create(String lastName) {
        if (StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException("Name cannot be null, blank or empty.");
        }
        if (lastName.length() > 50) {
            throw new IllegalArgumentException("Name cannot be longer than 50 characters: " + lastName);
        }
        if (!lastName.matches("^[\\p{L}\\s.,'\\-]+$")) {
            throw new IllegalArgumentException("Name contains invalid characters: " + lastName);
        }
        return new LastName(lastName.trim());
    }

}
