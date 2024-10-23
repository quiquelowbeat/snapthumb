package com.snapthumb.thumbnailgenerator.user_management.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Email;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.LastName;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Name;

public class User {

    private final UUID uuid;
    private final Name name;
    private final LastName lastName;
    private final Email email;
    private final HashedPassword hashedPassword;
    private LocalDateTime registeredAt;

    private User(UUID uuid, Name name, LastName lastName, Email email, HashedPassword hashedPassword,
            LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.registeredAt = registeredAt;
    }

    public static User create(UUID uuid, Name name, LastName lastName, Email email, HashedPassword hashedPassword) {
        return new User(uuid, name, lastName, email, hashedPassword, LocalDateTime.now());
    }

    public static User createWithRegisteredAt(UUID uuid, Name name, LastName lastName, Email email,
            HashedPassword hashedPassword, LocalDateTime registeredAt) {
        return new User(uuid, name, lastName, email, hashedPassword, registeredAt);
    }

    public UUID uuid() {
        return uuid;
    }

    public Name name() {
        return name;
    }

    public LastName lastName() {
        return lastName;
    }

    public Email email() {
        return email;
    }

    public HashedPassword hashedPassword() {
        return hashedPassword;
    }

    public LocalDateTime registeredAt() {
        return registeredAt;
    }

    @Override
    public String toString() {
        return "User [uuid=" + uuid + ", name=" + name + ", lastName=" + lastName + ", email=" + email
                + ", hashedPassword=" + hashedPassword + ", registeredAt=" + registeredAt + "]";
    }

}
