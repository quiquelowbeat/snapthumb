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

}
