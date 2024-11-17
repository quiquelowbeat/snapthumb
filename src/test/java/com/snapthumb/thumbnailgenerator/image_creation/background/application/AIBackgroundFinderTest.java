package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundMother;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.BackgroundNotFound;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.InMemoryAIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.shared.domain.exceptions.InvalidUuidFormat;

class AIBackgroundFinderTest {

    private AIBackgroundRepository repository;
    private AIBackgroundFinder finder;

    static Stream<AIBackground> aiBackgroundProvider() {
        return AIBackgroundMother.generateRandomAIBackgrounds(200);
    }

    @BeforeEach
    void setUp() {
        repository = new InMemoryAIBackgroundRepository();
        finder = new AIBackgroundFinder(repository);
    }

    @ParameterizedTest
    @MethodSource("aiBackgroundProvider")
    void should_return_background_when_exists(AIBackground background) {
        repository.save(background);
        String uuid = background.stringUuid();

        AIBackground foundBackground = finder.find(uuid);

        assertEquals(background.uuid(), foundBackground.uuid());
        assertEquals(background.url(), foundBackground.url());
        assertEquals(background.title(), foundBackground.title());
        assertEquals(background.description(), foundBackground.description());
        assertEquals(background.prompt(), foundBackground.prompt());
        assertEquals(background.createdAt(), foundBackground.createdAt());
        assertNotNull(foundBackground.registeredAt());
    }

    @Test
    void should_fail_when_background_does_not_exist() {
        String nonExistentUuid = UUID.randomUUID().toString();

        assertThrows(BackgroundNotFound.class,
                () -> finder.find(nonExistentUuid));
    }

    @Test
    void should_fail_when_uuid_is_invalid() {
        String invalidUuid = "invalid-uuid";

        assertThrows(InvalidUuidFormat.class,
                () -> finder.find(invalidUuid));
    }

    @Test
    void should_fail_when_uuid_is_null() {
        String nullUuid = null;

        assertThrows(InvalidUuidFormat.class,
                () -> finder.find(nullUuid));
    }

    @Test
    void should_fail_when_uuid_is_empty() {
        String emptyUuid = "";

        assertThrows(InvalidUuidFormat.class,
                () -> finder.find(emptyUuid));
    }

    @Test
    void should_fail_when_uuid_has_special_characters() {
        String specialCharsUuid = "!@#$%^&*()";

        assertThrows(InvalidUuidFormat.class,
                () -> finder.find(specialCharsUuid));
    }

}
