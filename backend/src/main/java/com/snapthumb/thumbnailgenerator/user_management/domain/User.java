package com.snapthumb.thumbnailgenerator.user_management.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.RegistrationDate;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Email;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.FirstName;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.LastName;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.entities.UserEntity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class User {

    private final UUID uuid;
    private final FirstName firstName;
    private final LastName lastName;
    private final Email email;
    private final HashedPassword hashedPassword;
    private RegistrationDate registeredAt;

    private User(UUID uuid, FirstName firstName, LastName lastName, Email email, HashedPassword hashedPassword,
            RegistrationDate registeredAt) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.registeredAt = registeredAt;
    }

    public static User createFromPrimitives(String uuid, String firstName,
            String lastName, String email, String hashedPassword) {
        return createUser(uuid, firstName, lastName, email, hashedPassword, LocalDateTime.now());
    }

    public static User createFromPrimitivesWithRegisteredAt(String uuid,
            String firstName,
            String lastName, String email, String hashedPassword, LocalDateTime registeredAt) {
        return createUser(uuid, firstName, lastName, email, hashedPassword, registeredAt);
    }

    public static User createFromRepository(UserEntity entity) {
        return createFromPrimitivesWithRegisteredAt(entity.uuid().toString(), entity.firstName(), entity.lastName(),
                entity.email(), entity.hashedPassword(), entity.registeredAt());
    }

    private static User createUser(String uuid, String firstName,
            String lastName, String email, String hashedPassword, LocalDateTime registeredAt) {

        return new User(
                UUID.fromString(uuid),
                FirstName.create(firstName),
                LastName.create(lastName),
                Email.create(email),
                HashedPassword.create(hashedPassword),
                RegistrationDate.create(registeredAt));
    }

    public UUID uuid() {
        return uuid;
    }

    public String stringUuid() {
        return uuid.toString();
    }

    public String firstName() {
        return firstName.value();
    }

    public String lastName() {
        return lastName.value();
    }

    public String email() {
        return email.value();
    }

    public String hashedPassword() {
        return hashedPassword.value();
    }

    public LocalDateTime registeredAt() {
        return registeredAt.value();
    }

}
