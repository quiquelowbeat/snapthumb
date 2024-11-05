package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.exceptions.InvalidDescriptionArgument;

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
            throw new InvalidDescriptionArgument("Description cannot be null.");
        }
        if (description.length() > 500) {
            throw new InvalidDescriptionArgument("Description cannot exceed 500 characters.");
        }
        return description;
    }

}
