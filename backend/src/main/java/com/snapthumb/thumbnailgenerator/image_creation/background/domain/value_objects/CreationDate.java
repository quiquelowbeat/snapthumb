package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.time.Instant;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class CreationDate {

    private final Instant value;

    private CreationDate(Instant createdAt) {
        this.value = createdAt;
    }

    public Instant value() {
        return value;
    }

    public static CreationDate create(Instant createdAt) {
        if (createdAt == null) {
            throw new IllegalArgumentException("Creation date cannot be null. A valid Instant must be provided.");
        }
        if (createdAt.equals(Instant.MIN)) {
            throw new IllegalArgumentException("Creation date cannot be empty. A valid date must be provided.");
        }
        if (createdAt.isAfter(Instant.now())) {
            throw new IllegalArgumentException("Creation date cannot be in the future.");
        }
        return new CreationDate(createdAt);
    }

}
