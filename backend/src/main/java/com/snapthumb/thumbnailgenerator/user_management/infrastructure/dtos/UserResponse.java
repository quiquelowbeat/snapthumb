package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snapthumb.thumbnailgenerator.user_management.domain.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@Schema(description = "Response object containing user information")
@ToString
public final class UserResponse {

    @JsonProperty("uuid")
    @Schema(description = "Unique identifier for the user", example = "123e4567-e89b-12d3-a456-426614174000")
    private final String uuid;

    @JsonProperty("firstName")
    @Schema(description = "User's first name", example = "John")
    private final String firstName;

    @JsonProperty("lastName")
    @Schema(description = "User's last name", example = "Doe")
    private final String lastName;

    @JsonProperty("email")
    @Schema(description = "User's email address", example = "john.doe@example.com")
    private final String email;

    @JsonProperty("registeredAt")
    @Schema(description = "Timestamp when the user registered in ISO 8601 format", example = "2023-01-01T12:00:00Z")
    private final Instant registeredAt;

    private UserResponse(String uuid, String firstName, String lastName, String email, Instant registeredAt) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registeredAt = registeredAt;
    }

    public static UserResponse createFrom(User user) {
        return new UserResponse(user.stringUuid(), user.firstName(), user.lastName(), user.email(),
                user.registeredAt());
    }

}
