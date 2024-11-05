package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.BackgroundNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UploadedBackgroundFinder {

    private final UploadedBackgroundRepository repository;

    public UploadedBackgroundFinder(UploadedBackgroundRepository repository) {
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
