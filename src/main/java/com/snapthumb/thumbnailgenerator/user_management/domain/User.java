package com.snapthumb.thumbnailgenerator.user_management.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Email;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Name;

public class User {

    private final UUID uuid;
    private final Name name;
    private final Email email;
    private final HashedPassword hashedPassword;
    private LocalDateTime registeredAt;

    private User(UUID uuid, Name name, Email email, HashedPassword hashedPassword,
            LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.registeredAt = registeredAt;
    }

    public static User createFromPrimitives(String uuid, String firstName, String lastName, String email,
            HashedPassword hashedPassword) {
        return new User(UUID.fromString(uuid), new Name(firstName, lastName), new Email(email),
                hashedPassword, LocalDateTime.now());
    }

    public static User createFromPrimitivesWithRegisteredAt(String uuid, String firstName, String lastName,
            String email,
            String passwordFromDatabase, LocalDateTime registeredAt) {
        return new User(UUID.fromString(uuid), new Name(firstName, lastName), new Email(email),
                new HashedPassword(passwordFromDatabase), registeredAt);
    }

    public UUID uuid() {
        return uuid;
    }

    public String stringUuid() {
        return uuid.toString();
    }

    public String firstName() {
        return name.firstName();
    }

    public String lastName() {
        return name.lastName();
    }

    public String email() {
        return email.value();
    }

    public String hashedPassword() {
        return hashedPassword.value();
    }

    public LocalDateTime registeredAt() {
        return registeredAt;
    }

    @Override
    public String toString() {
        return "User [uuid=" + uuid + ", name=" + name + ", email=" + email + ", hashedPassword=" + hashedPassword
                + ", registeredAt=" + registeredAt + "]";
    }

}
