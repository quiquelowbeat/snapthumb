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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prompt other = (Prompt) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
