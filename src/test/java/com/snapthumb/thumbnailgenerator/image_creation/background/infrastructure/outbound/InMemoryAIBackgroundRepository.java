package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;

import jakarta.persistence.EntityExistsException;

public class InMemoryAIBackgroundRepository implements AIBackgroundRepository {

    private final Map<UUID, AIBackground> aiBackgrounds = new HashMap<>();

    @Override
    public void save(AIBackground background) {
        if (alreadyExistsInDB(background.uuid())) {
            throw new EntityExistsException();
        }
        aiBackgrounds.put(background.uuid(), background);
    }

    @Override
    public Optional<AIBackground> search(UUID uuid) {
        return Optional.ofNullable(aiBackgrounds.get(uuid));
    }

    private boolean alreadyExistsInDB(UUID uuid) {
        Optional<AIBackground> optionalBackground = search(uuid);
        return optionalBackground.isPresent();
    }

}
