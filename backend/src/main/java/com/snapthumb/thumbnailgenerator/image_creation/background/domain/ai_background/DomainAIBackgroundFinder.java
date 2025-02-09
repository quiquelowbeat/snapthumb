package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.BackgroundNotFound;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DomainAIBackgroundFinder {

    private final AIBackgroundRepository repository;

    public DomainAIBackgroundFinder(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public Either<BackgroundNotFound, AIBackground> find(String uuid) {
        return repository.search(UUID.fromString(uuid)).map(Either::<BackgroundNotFound, AIBackground>right)
                .orElseGet(() -> Either.left(new BackgroundNotFound("AI background with id " + uuid + " not found")));
    }

}
