package com.snapthumb.thumbnailgenerator.user_management.domain.dtos;

public class UserRequest {

    private String uuid;
    private String name;
    private String lastName;
    private String email;
    private String rawPassword;

    

    public UserRequest(String uuid, String name, String lastName, String email, String rawPassword) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.rawPassword = rawPassword;
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
    public String rawPassword() {
        return rawPassword;
    }
    
}
