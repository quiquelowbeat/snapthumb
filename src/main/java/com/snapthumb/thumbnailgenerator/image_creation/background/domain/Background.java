package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.UUID;

public interface Background {
    UUID uuid();
    String title();
    String description();
    boolean isGeneratedByAI();
}
