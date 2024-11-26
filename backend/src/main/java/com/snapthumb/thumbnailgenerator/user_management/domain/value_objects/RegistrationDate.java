package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class RegistrationDate {

    private final LocalDateTime value;

    private RegistrationDate(LocalDateTime registeredAt) {
        this.value = registeredAt;
    }

    public LocalDateTime value() {
        return value;
    }

    public static RegistrationDate create(LocalDateTime registeredAt) {
        if (registeredAt == null) {
            throw new IllegalArgumentException(
                    "Registration date cannot be null. A valid LocalDateTime must be provided.");
        }
        if (registeredAt.equals(LocalDateTime.MIN)) {
            throw new IllegalArgumentException("Registration date cannot be empty. A valid date must be provided.");
        }
        if (registeredAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Registration date cannot be in the future.");
        }
        return new RegistrationDate(registeredAt);
    }

}
