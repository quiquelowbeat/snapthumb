package com.snapthumb.thumbnailgenerator.user_management.domain.dtos;

public class UserRequest {

    private String name;
    private String lastName;
    private String email;
    private String password;

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
