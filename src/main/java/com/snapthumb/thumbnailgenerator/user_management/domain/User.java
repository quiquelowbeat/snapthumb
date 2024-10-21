package com.snapthumb.thumbnailgenerator.user_management.domain;

import java.util.UUID;

import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Email;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.LastName;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Name;

public class User {

    private UUID uuid;
    private Name name;
    private LastName lastName;
    private Email email;
    private HashedPassword hashedPassword;

    public User(UUID uuid, Name name, LastName lastName, Email email, HashedPassword hashedPassword) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public UUID uuid() {
        return uuid;
    }

    public Name name() {
        return name;
    }

    public LastName lastName() {
        return lastName;
    }

    public Email email() {
        return email;
    }

    public HashedPassword hashedPassword() {
        return hashedPassword;
    }

    

}
