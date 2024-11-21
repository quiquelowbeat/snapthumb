package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(description = "Request object containing the prompt for AI image generation")
public class PromptRequest {

    @Schema(description = "Prompt text used to generate the AI image", example = "A serene mountain landscape at sunset")
    @JsonProperty("prompt")
    private String prompt;

    public PromptRequest() {
    }

    public PromptRequest(String prompt) {
        this.prompt = prompt;
    }

    public String prompt() {
        return prompt;
    }

}
