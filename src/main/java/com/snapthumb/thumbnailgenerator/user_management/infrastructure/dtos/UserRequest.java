package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

public class UserRequest {

    private final String firstName;
    private final String lastName;
    private final String email;
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
