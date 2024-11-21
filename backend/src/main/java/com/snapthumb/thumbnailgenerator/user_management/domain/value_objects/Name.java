package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode
@ToString
public class Name {

    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = validateName(firstName);
        this.lastName = validateName(lastName);
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    private String validateName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("Name cannot be longer than 50 characters");
        }
        if (!name.matches("^[\\p{L}\\s.,'\\-]+$")) {
            throw new IllegalArgumentException("Name contains invalid characters");
        }
        return name.trim();
    }

}
