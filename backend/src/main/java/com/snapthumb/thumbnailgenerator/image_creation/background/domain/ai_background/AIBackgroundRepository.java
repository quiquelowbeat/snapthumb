package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import java.util.Optional;
import java.util.UUID;

public interface AIBackgroundRepository {
    void save(AIBackground background);
    Optional<AIBackground> search(UUID uuid);
}
