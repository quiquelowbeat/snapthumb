package com.snapthumb.thumbnailgenerator.user_management.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Email;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.LastName;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private UUID uuid;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    protected UserEntity() {
    }

    public UserEntity(UUID uuid, String name, String lastName, String email, String password,
            LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registeredAt = registeredAt;
    }

    public User toDomainModel() {
        return User.createWithRegisteredAt(
                this.uuid,
                new Name(this.name),
                new LastName(this.lastName),
                new Email(this.email),
                new HashedPassword(this.password),
                this.registeredAt);
    }

    public static UserEntity fromDomainModel(User user) {
        return new UserEntity(user.uuid(), user.name().value(), user.lastName().value(), user.email().value(),
                user.hashedPassword().value(), user.registeredAt());
    }
}