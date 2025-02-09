package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGenerated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGeneration;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.CantGenerateAIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Prompt;

import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AIBackgroundGenerator {

    private final AIBackgroundGeneration generator;

    public AIBackgroundGenerator(AIBackgroundGeneration generator) {
        this.generator = generator;
    }

    public Either<CantGenerateAIBackground, AIBackgroundGenerated> generateBackground(String prompt) {
        return generator.generate(Prompt.create(prompt));
    }
}