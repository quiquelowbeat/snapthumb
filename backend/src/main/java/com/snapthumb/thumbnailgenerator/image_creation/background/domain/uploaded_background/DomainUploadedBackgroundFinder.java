package com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background;

import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.BackgroundNotFound;

import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainUploadedBackgroundFinder {

    private final UploadedBackgroundRepository repository;

    public DomainUploadedBackgroundFinder(UploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    public Either<BackgroundNotFound, UploadedBackground> find(String uuid) {
        return repository.search(UUID.fromString(uuid))
                .map(Either::<BackgroundNotFound, UploadedBackground>right)
                .orElseGet(() -> Either
                        .left(new BackgroundNotFound("Uploaded background with id " + uuid + " not found")));
    }

}
