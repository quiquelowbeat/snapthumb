package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.AIBackgroundNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AIBackgroundFinder {

    private final AIBackgroundRepository repository;

    public AIBackgroundFinder(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public AIBackground find(String uuid) {
        try {
            Optional<AIBackground> aiBackground = repository.search(UUID.fromString(uuid));
            if (aiBackground.isEmpty()) {
                log.error("AI Background not found with UUID: {}.", uuid);
                throw new AIBackgroundNotFound(uuid);
            }
            return aiBackground.get();
        } catch (IllegalArgumentException e) {
            log.error("Invalid UUID format: {}.", uuid);
            throw new AIBackgroundNotFound(uuid);
        }
    }
    
}
