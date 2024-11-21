package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Description {

    private final String value;

    public Description(String description) {
        this.value = validateDescription(description);
    }

    public String value() {
        return value;
    }

    private String validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }
        if (description.length() > 500) {
            throw new IllegalArgumentException("Description cannot exceed 500 characters.");
        }
        return description;
    }

}
