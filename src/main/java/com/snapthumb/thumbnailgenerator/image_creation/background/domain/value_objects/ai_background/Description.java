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
        Description other = (Description) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
