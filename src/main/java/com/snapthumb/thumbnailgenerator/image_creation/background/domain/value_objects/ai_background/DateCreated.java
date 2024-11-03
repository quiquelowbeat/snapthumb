package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background;

import java.time.LocalDateTime;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.exceptions.InvalidDateArgument;

public class DateCreated {

    private final LocalDateTime value;

    public DateCreated(LocalDateTime createdAt) {
        this.value = validateDate(createdAt);
    }

    public LocalDateTime value() {
        return value;
    }

    private LocalDateTime validateDate(LocalDateTime createdAt) {
        if (createdAt == null) {
            throw new InvalidDateArgument("Creation date cannot be null. A valid LocalDateTime must be provided.");
        }
        if (createdAt.equals(LocalDateTime.MIN)) {
            throw new InvalidDateArgument("Creation date cannot be empty. A valid date must be provided.");
        }
        if (createdAt.isAfter(LocalDateTime.now())) {
            throw new InvalidDateArgument("Creation date cannot be in the future.");
        }
        return createdAt;
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
        DateCreated other = (DateCreated) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
