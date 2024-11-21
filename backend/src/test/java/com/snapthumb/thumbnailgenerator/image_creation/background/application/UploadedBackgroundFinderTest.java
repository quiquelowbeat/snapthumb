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

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundMother;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.BackgroundNotFound;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.InMemoryUploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.shared.domain.exceptions.InvalidUuidFormat;

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

        UploadedBackground foundBackground = finder.find(uuid);

        assertEquals(background.uuid(), foundBackground.uuid());
        assertEquals(background.url(), foundBackground.url());
        assertEquals(background.title(), foundBackground.title());
        assertEquals(background.description(), foundBackground.description());
        assertEquals(background.uploadedAt(), foundBackground.uploadedAt());
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
