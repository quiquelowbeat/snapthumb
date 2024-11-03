package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.exceptions.InvalidDescriptionArgument;

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
