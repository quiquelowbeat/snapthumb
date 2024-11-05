package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Email {

    private final String value;

    public Email(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
