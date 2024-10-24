package com.snapthumb.thumbnailgenerator.user_management.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    protected UserEntity() {
    }

    public UserEntity(UUID uuid, String firstName, String lastName, String email, String password,
            LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registeredAt = registeredAt;
    }

    public User toDomainModel() {
        return User.createFromPrimitivesWithRegisteredAt(
                this.uuid.toString(),
                this.firstName,
                this.lastName,
                this.email,
                this.password,
                this.registeredAt);
    }

    public static UserEntity fromDomainModel(User user) {
        return new UserEntity(user.uuid(), user.firstName(), user.lastName(), user.email(), user.hashedPassword(),
                user.registeredAt());
    }
}