package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.exceptions.InvalidPromptArgument;

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
            throw new InvalidPromptArgument("Prompt cannot be null or empty.");
        }
        return prompt;
    }

}
