package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Title {

    private final String value;

    public Title(String title) {
        this.value = validateTitle(title);
    }

    public String value() {
        return value;
    }

    private String validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (title.length() > 100) {
            throw new IllegalArgumentException("Title cannot exceed 100 characters.");
        }
        return title;
    }

}
