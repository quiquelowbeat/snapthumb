package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;


import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Prompt {

    private final String value;

    private Prompt(String prompt) {
        this.value = prompt;
    }

    public String value() {
        return value;
    }

    public static Prompt create(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            throw new IllegalArgumentException("Prompt cannot be null or empty.");
        }
        return new Prompt(prompt);
    }

}
