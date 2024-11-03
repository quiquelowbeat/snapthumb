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

}
