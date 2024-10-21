package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

public class HashedPassword {

    private String value;

    public HashedPassword(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
