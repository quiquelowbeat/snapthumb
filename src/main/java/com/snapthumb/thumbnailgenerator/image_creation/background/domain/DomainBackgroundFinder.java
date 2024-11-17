package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.BackgroundNotFound;
import com.snapthumb.thumbnailgenerator.shared.domain.exceptions.InvalidUuidFormat;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DomainBackgroundFinder {

    private final AIBackgroundRepository repository;

    public DomainBackgroundFinder(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public AIBackground find(String uuid) {
        try {
            return repository.search(UUID.fromString(uuid))
                    .orElseThrow(() -> new BackgroundNotFound(uuid));
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Invalid UUID format: {}.", uuid, e);
            throw new InvalidUuidFormat(uuid);
        }
    }

}
