package com.snapthumb.thumbnailgenerator.user_management.domain.value_objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode
@ToString
public class Name {

    private final String firstName;
    private final String lastName;

    private Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public static Name create(String firstName, String lastName) {
        String validatedFirstName = validateName(firstName);
        String validatedLastName = validateName(lastName);
        return new Name(validatedFirstName, validatedLastName);
    }

    private static String validateName(String name) {
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
