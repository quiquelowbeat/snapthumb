package com.snapthumb.thumbnailgenerator.user_management.domain.dtos;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class UserResponse {

    private String uuid;
    private String name;
    private String lastName;
    private String email;
    private LocalDateTime registeredAt;

    public UserResponse(String uuid, String name, String lastName, String email, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.registeredAt = registeredAt;
    }

}
