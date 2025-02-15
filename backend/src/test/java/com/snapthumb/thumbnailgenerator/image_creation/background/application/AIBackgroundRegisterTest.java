package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundMother;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.InMemoryAIBackgroundRepository;

import jakarta.persistence.EntityExistsException;

class AIBackgroundRegisterTest {

        private AIBackgroundRepository repository;
        private AIBackgroundRegister register;

        static Stream<AIBackground> aiBackgroundProvider() {
                return AIBackgroundMother.generateRandomAIBackgrounds(200);
        }

        static Stream<Object[]> nullParametersProvider() {
                return Stream.of(
                                new Object[] { UUID.randomUUID().toString(), null, "Prompt test", "Title test",
                                                "Description test",
                                                Instant.now() },
                                new Object[] { UUID.randomUUID().toString(), "http://www.test.com", null, "Title test",
                                                "Description test", Instant.now() },
                                new Object[] { UUID.randomUUID().toString(), "http://www.test.com", "Prompt test", null,
                                                "Description test", Instant.now() },
                                new Object[] { UUID.randomUUID().toString(), "http://www.test.com", "Prompt test",
                                                "Title test", null,
                                                Instant.now() },
                                new Object[] { UUID.randomUUID().toString(), "http://www.test.com", "Prompt test",
                                                "Title test",
                                                "Description test", null });
        }

        @BeforeEach
        void setUp() {
                repository = new InMemoryAIBackgroundRepository();
                register = new AIBackgroundRegister(repository);
        }

        @ParameterizedTest
        @MethodSource("aiBackgroundProvider")
        void should_register_a_new_ai_background(AIBackground background) {
                register.register(background.uuid().toString(),
                                background.url(),
                                background.prompt(),
                                background.title(),
                                background.description(),
                                background.createdAt());

                Optional<AIBackground> optionalBackground = repository.search(background.uuid());
                AIBackground persistedBackground = optionalBackground.orElseThrow();

                assertEquals(persistedBackground.uuid(), background.uuid());
                assertEquals(persistedBackground.url(), background.url());
                assertEquals(persistedBackground.prompt(), background.prompt());
                assertEquals(persistedBackground.title(), background.title());
                assertEquals(persistedBackground.description(), background.description());
                assertEquals(persistedBackground.createdAt(), background.createdAt());
                assertNotNull(persistedBackground.registeredAt());
        }

        @Test
        void should_fail_register_due_to_null_uuid() {
                String invalidUuid = null;
                String url = "http://www.test.com";
                String prompt = "Prompt test";
                String title = "Title test";
                String description = "Description test";
                Instant createdAt = Instant.now();

                assertThrows(NullPointerException.class,
                                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
        }

        @Test
        void should_fail_register_due_to_wrong_uuid() {
                String invalidUuid = "WrongUUID";
                String url = "http://www.test.com";
                String prompt = "Prompt test";
                String title = "Title test";
                String description = "Description test";
                Instant createdAt = Instant.now();

                assertThrows(IllegalArgumentException.class,
                                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
        }

        @Test
        void should_fail_register_due_to_invalid_url() {
                String invalidUuid = UUID.randomUUID().toString();
                String url = "www.test.com";
                String prompt = "Prompt test";
                String title = "Title test";
                String description = "Description test";
                Instant createdAt = Instant.now();

                assertThrows(IllegalArgumentException.class,
                                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
        }

        @ParameterizedTest
        @MethodSource("nullParametersProvider")
        void should_fail_register_when_parameter_is_null(String uuid, String url, String prompt, String title,
                        String description, Instant uploadedAt) {
                assertThrows(IllegalArgumentException.class,
                                () -> register.register(uuid, url, prompt, title, description, uploadedAt));
        }

        @Test
        void should_fail_register_due_to_empty_created_at() {
                String invalidUuid = UUID.randomUUID().toString();
                String url = "http://www.test.com";
                String prompt = "Prompt test";
                String title = "Title test";
                String description = "Description test";
                Instant createdAt = Instant.MIN;

                assertThrows(IllegalArgumentException.class,
                                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
        }

        @Test
        void should_fail_register_due_to_future_created_at() {
                String invalidUuid = UUID.randomUUID().toString();
                String url = "http://www.test.com";
                String prompt = "Prompt test";
                String title = "Title test";
                String description = "Description test";
                Instant createdAt = Instant.now().plusDays(1);

                assertThrows(IllegalArgumentException.class,
                                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
        }

        @Test
        void should_fail_register_due_to_existing_uuid() {
                String uuid = UUID.randomUUID().toString();
                String url = "http://www.test.com";
                String prompt = "Prompt test";
                String title = "Title test";
                String description = "Description test";
                Instant createdAt = Instant.now();

                String anotherUrl = "http://www.anothertest.com";
                String anotherPrompt = "Another Prompt test";
                String anotherTitle = "Another Title test";
                String anotherDescription = "Another Description test";
                Instant anotherCreatedAt = Instant.now();

                register.register(uuid, url, prompt, title, description, createdAt);

                assertThrows(EntityExistsException.class,
                                () -> register.register(uuid, anotherUrl, anotherPrompt, anotherTitle,
                                                anotherDescription,
                                                anotherCreatedAt));
        }

}
