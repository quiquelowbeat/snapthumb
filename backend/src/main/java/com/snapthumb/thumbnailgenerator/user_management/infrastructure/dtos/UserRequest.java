package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(description = "Request object for creating or updating a user")
public class UserRequest {

    @JsonProperty("firstName")
    @Schema(description = "User's first name", example = "John")
    private final String firstName;

    @JsonProperty("lastName")
    @Schema(description = "User's last name", example = "Doe")
    private final String lastName;

    @JsonProperty("email")
    @Schema(description = "User's email address", example = "john.doe@example.com")
    private final String email;

    @JsonProperty("password")
    @Schema(description = "User's password", example = "securePassword123")
    private final String password;

    public UserRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

}
