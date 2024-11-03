package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantRegisterBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.ai_background.exceptions.InvalidBackgroundArgument;

import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AIBackgroundRegister {

    private final AIBackgroundRepository repository;

    public AIBackgroundRegister(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public void register(String uuid, String url, String prompt, String title, String description,
            LocalDateTime createdAt) {
        try {
            AIBackground background = AIBackground.create(UUID.fromString(uuid), url, prompt, title,
                    description, createdAt);
            repository.save(background);
        } catch (PersistenceException e) {
            log.error("Can't save AI Background with UUID: {}.", uuid, e);
            throw new CantRegisterBackground(e, uuid);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Can't save AI Background.", e);
            throw new CantRegisterBackground(e, uuid);
        } catch (InvalidBackgroundArgument e) {
            log.error("Can't save AI Background.", e);
            throw new CantRegisterBackground(e, uuid);
        }
    }

}
