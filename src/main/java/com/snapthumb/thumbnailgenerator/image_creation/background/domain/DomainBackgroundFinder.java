package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.Optional;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.BackgroundNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainBackgroundFinder {

    private final AIBackgroundRepository repository;

    public DomainBackgroundFinder(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public AIBackground find(String uuid) {
        try {
            Optional<AIBackground> optionalBackground = repository.search(UUID.fromString(uuid));
            if (optionalBackground.isEmpty()) {
                log.error("AI Background not found with UUID: {}.", uuid);
                throw new BackgroundNotFound(uuid);
            }
            return optionalBackground.get();
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Invalid UUID format: {}.", uuid);
            throw new BackgroundNotFound(uuid);
        }
    }
    
}
