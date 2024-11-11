package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.BackgroundNotFound;
import com.snapthumb.thumbnailgenerator.shared.domain.exceptions.InvalidUuidFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainUploadedBackgroundFinder {

    private final UploadedBackgroundRepository repository;

    public DomainUploadedBackgroundFinder(UploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    public UploadedBackground find(String uuid) {
        try {
            return repository.search(UUID.fromString(uuid))
                    .orElseThrow(() -> new BackgroundNotFound(uuid));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new InvalidUuidFormat(uuid);
        }
    }

}
