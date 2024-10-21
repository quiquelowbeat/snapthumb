package com.snapthumb.thumbnailgenerator.user_management.domain.dtos;

public class UserResponse {

    private String uuid;
    private String name;
    private String lastName;
    private String email;

    public UserResponse(String uuid, String name, String lastName, String email) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String uuid() {
        return uuid;
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

}
