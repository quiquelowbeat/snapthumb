package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.Optional;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.BackgroundNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainUploadedBackgroundFinder {

    private final UploadedBackgroundRepository repository;

    public DomainUploadedBackgroundFinder(UploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    public UploadedBackground find(String uuid) {
        try {
            Optional<UploadedBackground> optionalBackground = repository.search(UUID.fromString(uuid));
            if (optionalBackground.isEmpty()) {
                log.error("Uploaded Background not found with UUID: {}.", uuid);
                throw new BackgroundNotFound(uuid);
            }
            return optionalBackground.get();
        } catch (IllegalArgumentException e) {
            log.error("Invalid UUID format: {}.", uuid);
            throw new BackgroundNotFound(uuid);
        }
    }

}
