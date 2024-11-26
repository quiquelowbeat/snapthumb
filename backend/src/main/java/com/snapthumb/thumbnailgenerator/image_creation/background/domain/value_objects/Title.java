package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Title {
    private final String value;

    private Title(String title) {
        this.value = title;
    }

    public String value() {
        return value;
    }

    public static Title create(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (title.length() > 100) {
            throw new IllegalArgumentException("Title cannot exceed 100 characters.");
        }
        return new Title(title);
    }

}
