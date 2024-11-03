package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background;

import java.time.LocalDateTime;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.exceptions.InvalidDateArgument;

public class DateRegistered {

    private final LocalDateTime value;

    public DateRegistered(LocalDateTime registeredAt) {
        this.value = validateDate(registeredAt);
    }

    public LocalDateTime value() {
        return value;
    }

    private LocalDateTime validateDate(LocalDateTime registeredAt) {
        if (registeredAt == null) {
            throw new InvalidDateArgument("Registration date cannot be null. A valid LocalDateTime must be provided.");
        }
        if (registeredAt.equals(LocalDateTime.MIN)) {
            throw new InvalidDateArgument("Registration date cannot be empty. A valid date must be provided.");
        }
        if (registeredAt.isAfter(LocalDateTime.now())) {
            throw new InvalidDateArgument("Registration date cannot be in the future.");
        }
        return registeredAt;
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
        DateRegistered other = (DateRegistered) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
