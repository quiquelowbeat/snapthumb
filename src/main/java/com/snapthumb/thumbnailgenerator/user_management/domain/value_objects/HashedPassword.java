package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class HashedPassword {

    private final String value;

    public HashedPassword(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
