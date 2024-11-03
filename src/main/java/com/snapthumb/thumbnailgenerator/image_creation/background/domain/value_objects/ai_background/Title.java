package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.exceptions.InvalidTitleArgument;

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
            throw new InvalidTitleArgument("Title cannot be null or empty.");
        }
        if (title.length() > 100) {
            throw new InvalidTitleArgument("Title cannot exceed 100 characters.");
        }
        return title;
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
        Title other = (Title) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
