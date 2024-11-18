package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGenerated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGeneration;
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
        return generator.generate(new Prompt(prompt));
    }

}
