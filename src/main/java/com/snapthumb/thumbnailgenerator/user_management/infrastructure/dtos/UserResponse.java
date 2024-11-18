package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

import java.time.LocalDateTime;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Response object containing user information")
public class UserResponse {

    @Schema(description = "Unique identifier for the user", example = "123e4567-e89b-12d3-a456-426614174000")
    private final String uuid;

    @Schema(description = "User's first name", example = "John")
    private final String firstName;

    @Schema(description = "User's last name", example = "Doe") 
    private final String lastName;

    @Schema(description = "User's email address", example = "john.doe@example.com")
    private final String email;

    @Schema(description = "Timestamp when the user registered", example = "2023-01-01T12:00:00")
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
