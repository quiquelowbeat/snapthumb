package com.snapthumb.thumbnailgenerator.user_management.domain;

public class UserRequest {

    private String uuid;
    private String name;
    private String lastName;
    private String email;
    private String rawPassword;

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
    public String rawPassword() {
        return rawPassword;
    }
    
}
