package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

public class LastName {

    private final String value;

    public LastName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
