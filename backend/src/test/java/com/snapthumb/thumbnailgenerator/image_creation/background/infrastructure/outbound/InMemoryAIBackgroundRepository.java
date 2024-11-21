package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundRepository;

import jakarta.persistence.EntityExistsException;

public class InMemoryAIBackgroundRepository implements AIBackgroundRepository {

    private final Map<UUID, AIBackground> aiBackgrounds = new HashMap<>();

    @Override
    public void save(AIBackground background) {
        if (aiBackgrounds.containsKey(background.uuid())) {
            throw new EntityExistsException();
        }
        aiBackgrounds.put(background.uuid(), background);
    }

    @Override
    public Optional<AIBackground> search(UUID uuid) {
        return Optional.ofNullable(aiBackgrounds.get(uuid));
    }

}
