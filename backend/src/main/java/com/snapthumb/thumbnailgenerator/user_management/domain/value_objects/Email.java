package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Email {

    private final String value;

    private Email(String email) {
        this.value = email;
    }

    public String value() {
        return value;
    }

    public static Email create(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }

        String trimmedEmail = email.trim();
        
        if (trimmedEmail.length() > 254) {
            throw new IllegalArgumentException("Email cannot be longer than 254 characters.");
        }

        if (!trimmedEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        return new Email(trimmedEmail);
    }

}
