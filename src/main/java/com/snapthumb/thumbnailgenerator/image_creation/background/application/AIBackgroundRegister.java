package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantRegisterBackground;

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
            AIBackground background = AIBackground.createFromPrimitives(UUID.fromString(uuid), url, prompt, title,
                    description, createdAt);
            repository.save(background);
        } catch (IllegalArgumentException | NullPointerException | PersistenceException e) {
            log.error("Can't save AI Background with UUID: {}.", uuid, e);
            throw new CantRegisterBackground(uuid, e);
        }
    }

}
