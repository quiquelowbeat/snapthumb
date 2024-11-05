package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.Optional;
import java.util.UUID;

public interface AIBackgroundRepository {
    void save(AIBackground background);

    Optional<AIBackground> search(UUID uuid);
}
