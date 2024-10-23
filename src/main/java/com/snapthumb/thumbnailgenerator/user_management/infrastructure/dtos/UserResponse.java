package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class UserResponse {

    private final String uuid;
    private final String name;
    private final String lastName;
    private final String email;
    private final LocalDateTime registeredAt;

    public UserResponse(String uuid, String name, String lastName, String email, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.registeredAt = registeredAt;
    }

}
