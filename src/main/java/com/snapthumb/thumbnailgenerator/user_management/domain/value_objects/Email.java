package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Email {

    private final String value;

    public Email(String email) {
        this.value = validateEmail(email);
    }

    public String value() {
        return value;
    }

    private String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        String trimmedEmail = email.trim();
        
        if (trimmedEmail.length() > 254) {
            throw new IllegalArgumentException("Email cannot be longer than 254 characters");
        }

        if (!trimmedEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return trimmedEmail;
    }

}
