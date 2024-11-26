package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Description {

    private final String value;

    private Description(String description) {
        this.value = description;
    }

    public String value() {
        return value;
    }

    public static Description create(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }
        if (description.length() > 500) {
            throw new IllegalArgumentException("Description cannot exceed 500 characters.");
        }
        return new Description(description);
    }

}
