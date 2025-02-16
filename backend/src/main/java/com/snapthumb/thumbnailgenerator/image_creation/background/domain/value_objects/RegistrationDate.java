package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.time.Instant;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class RegistrationDate {

    private final Instant value;

    private RegistrationDate(Instant registeredAt) {
        this.value = registeredAt;
    }

    public Instant value() {
        return value;
    }

    public static RegistrationDate create(Instant registeredAt) {
        if (registeredAt == null) {
            throw new IllegalArgumentException(
                    "Registration date cannot be null. A valid Instant in ISO 8601 format must be provided.");
        }
        if (registeredAt.equals(Instant.MIN)) {
            throw new IllegalArgumentException("Registration date cannot be empty. A valid date must be provided.");
        }
        if (registeredAt.isAfter(Instant.now())) {
            throw new IllegalArgumentException("Registration date cannot be in the future.");
        }
        return new RegistrationDate(registeredAt);
    }

}
