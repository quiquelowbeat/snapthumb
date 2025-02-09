package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Prompt;

import io.vavr.control.Either;

public interface AIBackgroundGeneration {
    Either<CantGenerateAIBackground, AIBackgroundGenerated> generate(Prompt prompt);
}