package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundMother;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.BackgroundNotFound;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.InMemoryAIBackgroundRepository;

import io.vavr.control.Either;

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

        Either<BackgroundNotFound, AIBackground> result = finder.find(uuid);

        result.fold(error -> fail("should not be called"), found -> {
            assertTrue(result.isRight());
            assertEquals(background.uuid(), found.uuid());
            assertEquals(background.url(), found.url());
            assertEquals(background.title(), found.title());
            assertEquals(background.description(), found.description());
            assertEquals(background.prompt(), found.prompt());
            assertEquals(background.createdAt(), found.createdAt());
            assertNotNull(found.registeredAt());
            return Void.TYPE;
        });

    }

    @Test
    void should_fail_when_background_does_not_exist() {
        String nonExistentUuid = UUID.randomUUID().toString();

        Either<BackgroundNotFound, AIBackground> result = finder.find(nonExistentUuid);

        assertTrue(result.isLeft());
    }

    @Test
    void should_fail_find_due_to_null_uuid() {
        String invalidUuid = null;

        assertThrows(NullPointerException.class,
                () -> finder.find(invalidUuid));
    }

    @Test
    void should_fail_find_due_to_wrong_uuid() {
        String invalidUuid = "WrongUUID";

        assertThrows(IllegalArgumentException.class,
                () -> finder.find(invalidUuid));
    }

    @Test
    void should_fail_when_uuid_is_empty() {
        String emptyUuid = "";

        assertThrows(IllegalArgumentException.class,
                () -> finder.find(emptyUuid));
    }

    @Test
    void should_fail_when_uuid_has_special_characters() {
        String specialCharsUuid = "!@#$%^&*()";

        assertThrows(IllegalArgumentException.class,
                () -> finder.find(specialCharsUuid));
    }

}
