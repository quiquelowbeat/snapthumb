package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

import java.time.LocalDateTime;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;

import lombok.Getter;

@Getter
public class UserResponse {

    private final String uuid;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDateTime registeredAt;

    private UserResponse(String uuid, String firstName, String lastName, String email, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registeredAt = registeredAt;
    }

    public static UserResponse create(User user) {
        return new UserResponse(user.stringUuid(), user.firstName(), user.lastName(), user.email(),
                user.registeredAt());
    }

}
