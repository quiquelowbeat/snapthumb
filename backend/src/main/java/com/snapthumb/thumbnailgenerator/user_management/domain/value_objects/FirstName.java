package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class FirstName {

    private final String value;

    public FirstName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
