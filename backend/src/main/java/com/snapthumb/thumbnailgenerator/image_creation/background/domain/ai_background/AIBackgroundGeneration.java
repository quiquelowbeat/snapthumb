package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Prompt;

public interface AIBackgroundGeneration {
    AIBackgroundGenerated generate(Prompt prompt);
}