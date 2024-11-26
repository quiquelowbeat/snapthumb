package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class CreationDate {

    private final LocalDateTime value;

    private CreationDate(LocalDateTime createdAt) {
        this.value = createdAt;
    }

    public LocalDateTime value() {
        return value;
    }

    public static CreationDate create(LocalDateTime createdAt) {
        if (createdAt == null) {
            throw new IllegalArgumentException("Creation date cannot be null. A valid LocalDateTime must be provided.");
        }
        if (createdAt.equals(LocalDateTime.MIN)) {
            throw new IllegalArgumentException("Creation date cannot be empty. A valid date must be provided.");
        }
        if (createdAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Creation date cannot be in the future.");
        }
        return new CreationDate(createdAt);
    }

}
