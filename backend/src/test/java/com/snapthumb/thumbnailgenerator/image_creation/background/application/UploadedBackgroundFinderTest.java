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

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.BackgroundNotFound;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundMother;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.InMemoryUploadedBackgroundRepository;

import io.vavr.control.Either;

class UploadedBackgroundFinderTest {

    private UploadedBackgroundRepository repository;
    private UploadedBackgroundFinder finder;

    static Stream<UploadedBackground> uploadedBackgroundProvider() {
        return UploadedBackgroundMother.generateRandomUploadedBackgrounds(200);
    }

    @BeforeEach
    void setUp() {
        repository = new InMemoryUploadedBackgroundRepository();
        finder = new UploadedBackgroundFinder(repository);
    }

    @ParameterizedTest
    @MethodSource("uploadedBackgroundProvider")
    void should_return_background_when_exists(UploadedBackground background) {
        repository.save(background);
        String uuid = background.stringUuid();

        Either<BackgroundNotFound, UploadedBackground> result = finder.find(uuid);

        result.fold(error -> fail("should not be called"), found -> {
            assertTrue(result.isRight());
            assertEquals(background.uuid(), found.uuid());
            assertEquals(background.url(), found.url());
            assertEquals(background.title(), found.title());
            assertEquals(background.description(), found.description());
            assertEquals(background.uploadedAt(), found.uploadedAt());
            assertNotNull(found.registeredAt());
            return Void.TYPE;
        });
    }

    @Test
    void should_fail_when_background_does_not_exist() {
        String nonExistentUuid = UUID.randomUUID().toString();

        Either<BackgroundNotFound, UploadedBackground> result = finder.find(nonExistentUuid);
        BackgroundNotFound error = result.getLeft();

        assertNotNull(error);
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
