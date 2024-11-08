package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;


import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Prompt {

    private final String value;

    public Prompt(String prompt) {
        this.value = validatePrompt(prompt);
    }

    public String value() {
        return value;
    }

    private String validatePrompt(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            throw new IllegalArgumentException("Prompt cannot be null or empty.");
        }
        return prompt;
    }

}
