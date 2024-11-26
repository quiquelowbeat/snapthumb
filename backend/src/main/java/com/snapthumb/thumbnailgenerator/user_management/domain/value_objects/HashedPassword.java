package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class HashedPassword {

    private final String value;

    private HashedPassword(String hashedPassword) {
        this.value = hashedPassword;
    }

    public String value() {
        return value;
    }

    public static HashedPassword create(String hashedPassword) {
        if (hashedPassword == null || hashedPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Hashed password cannot be null or empty");
        }

        String trimmedPassword = hashedPassword.trim();

        if (trimmedPassword.length() < 60 || trimmedPassword.length() > 60) {
            throw new IllegalArgumentException("Invalid hashed password length");
        }

        if (!trimmedPassword.matches("^\\$2[ayb]\\$.{56}$")) {
            throw new IllegalArgumentException("Invalid hashed password format");
        }

        return new HashedPassword(trimmedPassword);
    }

}
