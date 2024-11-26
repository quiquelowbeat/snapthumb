package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGenerated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGeneration;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantGenerateAIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Prompt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AIBackgroundGenerator {

    private final AIBackgroundGeneration generator;

    public AIBackgroundGenerator(AIBackgroundGeneration generator) {
        this.generator = generator;
    }

    public AIBackgroundGenerated generateBackground(String prompt) {
        try {
            return generator.generate(Prompt.create(prompt));
        } catch (Exception e) {
            log.error("Error generating AI background with prompt: {}.", prompt, e);
            throw new CantGenerateAIBackground(e);
        }
    }
}