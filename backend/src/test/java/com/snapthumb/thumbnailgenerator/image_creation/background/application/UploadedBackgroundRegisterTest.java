package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundMother;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantRegisterBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.InMemoryUploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.shared.domain.exceptions.InvalidDataSent;

import jakarta.persistence.PersistenceException;

class UploadedBackgroundRegisterTest {
        private UploadedBackgroundRepository repository;
        private UploadedBackgroundRegister register;

        static Stream<UploadedBackground> uploadedBackgroundProvider() {
                return UploadedBackgroundMother.generateRandomUploadedBackgrounds(200);
        }

        static Stream<Object[]> nullParametersProvider() {
                return Stream.of(
                                new Object[] { null, "http://www.test.com", "Title test", "Description test",
                                                LocalDateTime.now() },
                                new Object[] { UUID.randomUUID().toString(), null, "Title test", "Description test",
                                                LocalDateTime.now() },
                                new Object[] { UUID.randomUUID().toString(), "http://www.test.com", null,
                                                "Description test",
                                                LocalDateTime.now() },
                                new Object[] { UUID.randomUUID().toString(), "http://www.test.com", "Title test", null,
                                                LocalDateTime.now() },
                                new Object[] { UUID.randomUUID().toString(), "http://www.test.com", "Title test",
                                                "Description test",
                                                null });
        }

        @BeforeEach
        void setUp() {
                repository = new InMemoryUploadedBackgroundRepository();
                register = new UploadedBackgroundRegister(repository);
        }

        @ParameterizedTest
        @MethodSource("uploadedBackgroundProvider")
        void should_register_a_new_uploaded_background(UploadedBackground background) {
                register.register(background.uuid().toString(),
                                background.url(),
                                background.title(),
                                background.description(),
                                background.uploadedAt());

                Optional<UploadedBackground> optionalBackground = repository.search(background.uuid());
                UploadedBackground persistedBackground = optionalBackground.get();

                assertEquals(persistedBackground.uuid(), background.uuid());
                assertEquals(persistedBackground.url(), background.url());
                assertEquals(persistedBackground.title(), background.title());
                assertEquals(persistedBackground.description(), background.description());
                assertEquals(persistedBackground.uploadedAt(), background.uploadedAt());
                assertNotNull(persistedBackground.registeredAt());
        }

        @Test
        void should_fail_register_due_to_wrong_uuid() {
                String invalidUuid = "WrongUUID";
                String url = "http://www.test.com";
                String title = "Title test";
                String description = "Description test";
                LocalDateTime uploadedAt = LocalDateTime.now();

                assertThrows(InvalidDataSent.class,
                                () -> register.register(invalidUuid, url, title, description, uploadedAt));
        }

        @Test
        void should_fail_register_due_to_invalid_url() {
                String invalidUuid = UUID.randomUUID().toString();
                String url = "www.test.com";
                String title = "Title test";
                String description = "Description test";
                LocalDateTime uploadedAt = LocalDateTime.now();

                assertThrows(InvalidDataSent.class,
                                () -> register.register(invalidUuid, url, title, description, uploadedAt));
        }

        @ParameterizedTest
        @MethodSource("nullParametersProvider")
        void should_fail_register_when_parameter_is_null(String uuid, String url, String title,
                        String description, LocalDateTime uploadedAt) {
                assertThrows(InvalidDataSent.class,
                                () -> register.register(uuid, url, title, description, uploadedAt));
        }

        @Test
        void should_fail_register_due_to_empty_created_at() {
                String invalidUuid = UUID.randomUUID().toString();
                String url = "http://www.test.com";
                String title = "Title test";
                String description = "Description test";
                LocalDateTime uploadedAt = LocalDateTime.MIN;

                assertThrows(InvalidDataSent.class,
                                () -> register.register(invalidUuid, url, title, description, uploadedAt));
        }

        @Test
        void should_fail_register_due_to_future_created_at() {
                String invalidUuid = UUID.randomUUID().toString();
                String url = "http://www.test.com";
                String title = "Title test";
                String description = "Description test";
                LocalDateTime uploadedAt = LocalDateTime.now().plusDays(1);

                assertThrows(InvalidDataSent.class,
                                () -> register.register(invalidUuid, url, title, description, uploadedAt));
        }

        @Test
        void should_fail_register_due_to_persistence_exception() {
                String uuid = UUID.randomUUID().toString();
                String url = "http://www.test.com";
                String title = "Title test";
                String description = "Description test";
                LocalDateTime uploadedAt = LocalDateTime.now();

                InMemoryUploadedBackgroundRepository failingRepository = new InMemoryUploadedBackgroundRepository() {
                        @Override
                        public void save(UploadedBackground background) {
                                throw new PersistenceException();
                        }
                };
                UploadedBackgroundRegister failingRegister = new UploadedBackgroundRegister(failingRepository);

                assertThrows(CantRegisterBackground.class,
                                () -> failingRegister.register(uuid, url, title, description, uploadedAt));
        }

        @Test
        void should_fail_register_due_to_existing_uuid() {
                String uuid = UUID.randomUUID().toString();
                String url = "http://www.test.com";
                String title = "Title test";
                String description = "Description test";
                LocalDateTime uploadedAt = LocalDateTime.now();

                String anotherUrl = "anothertest.com";
                String anotherTitle = "Another Title test";
                String anotherDescription = "Another Description test";
                LocalDateTime anotherUploadedAt = LocalDateTime.now();

                register.register(uuid, url, title, description, uploadedAt);

                assertThrows(InvalidDataSent.class,
                                () -> register.register(uuid, anotherUrl, anotherTitle, anotherDescription,
                                                anotherUploadedAt));
        }

}
