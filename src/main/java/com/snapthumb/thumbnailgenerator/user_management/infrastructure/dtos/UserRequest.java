package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

public class UserRequest {

    private final String name;
    private final String lastName;
    private final String email;
    private final String password;

    public UserRequest(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String name() {
        return name;
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
