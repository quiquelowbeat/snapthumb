package com.snapthumb.thumbnailgenerator.user_management.infrastructure.entities;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@Entity
@Table(name = "users")
public final class UserEntity {
    @Id
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    @Column(name = "password")
    private String hashedPassword;
    @Column(name = "registered_at", updatable = false)
    private Instant registeredAt;

    protected UserEntity() {
    }

    public UserEntity(UUID uuid, String firstName, String lastName, String email, String hashedPassword,
            Instant registeredAt) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.registeredAt = registeredAt;
    }

}