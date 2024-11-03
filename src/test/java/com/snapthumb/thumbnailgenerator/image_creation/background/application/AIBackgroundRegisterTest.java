package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundMother;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantRegisterBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.InMemoryAIBackgroundRepository;

import jakarta.persistence.PersistenceException;

class AIBackgroundRegisterTest {

    private AIBackgroundRepository repository;
    private AIBackgroundRegister register;

    static Stream<AIBackground> aiBackgroundProvider() {
        return AIBackgroundMother.generateRandomAIBackgrounds(200);
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
        AIBackground persistedBackground = optionalBackground.get();

        assertEquals(persistedBackground.uuid(), background.uuid());
        assertEquals(persistedBackground.url(), background.url());
        assertEquals(persistedBackground.prompt(), background.prompt());
        assertEquals(persistedBackground.title(), background.title());
        assertEquals(persistedBackground.description(), background.description());
        assertEquals(persistedBackground.createdAt(), background.createdAt());
        assertEquals(persistedBackground.registeredAt().truncatedTo(ChronoUnit.SECONDS),
                LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    @Test
    void should_fail_register_due_to_wrong_uuid() {
        String invalidUuid = "WrongUUID";
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_null_uuid() {
        String invalidUuid = null;
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_null_url() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = null;
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_invalid_url() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = "www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_null_prompt() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = null;
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_null_title() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = null;
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_null_description() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = null;
        LocalDateTime createdAt = LocalDateTime.now();

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_null_created_at() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = null;

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_empty_created_at() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.MIN;

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_future_created_at() {
        String invalidUuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now().plusDays(1);

        assertThrows(CantRegisterBackground.class,
                () -> register.register(invalidUuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_persistence_exception() {
        String uuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        InMemoryAIBackgroundRepository failingRepository = new InMemoryAIBackgroundRepository() {
            @Override
            public void save(AIBackground background) {
                throw new PersistenceException();
            }
        };
        AIBackgroundRegister failingRegister = new AIBackgroundRegister(failingRepository);

        assertThrows(CantRegisterBackground.class,
                () -> failingRegister.register(uuid, url, prompt, title, description, createdAt));
    }

    @Test
    void should_fail_register_due_to_existing_uuid() {
        String uuid = UUID.randomUUID().toString();
        String url = "http://www.test.com";
        String prompt = "Prompt test";
        String title = "Title test";
        String description = "Description test";
        LocalDateTime createdAt = LocalDateTime.now();

        String anotherUrl = "anothertest.com";
        String anotherPrompt = "Another Prompt test";
        String anotherTitle = "Another Title test";
        String anotherDescription = "Another Description test";
        LocalDateTime anotherCreatedAt = LocalDateTime.now();

        register.register(uuid, url, prompt, title, description, createdAt);

        assertThrows(CantRegisterBackground.class,
                () -> register.register(uuid, anotherUrl, anotherPrompt, anotherTitle, anotherDescription,
                        anotherCreatedAt));
    }

}
