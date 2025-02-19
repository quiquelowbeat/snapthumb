package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AIBackgroundRegister {

    private final AIBackgroundRepository repository;

    public AIBackgroundRegister(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public void register(String uuid, String url, String prompt, String title, String description,
            Instant createdAt) {
        AIBackground background = AIBackground.createFromPrimitives(uuid, url, prompt, title,
                description, createdAt);
        repository.save(background);
        log.info("Successfully registered AI background with UUID: {}", uuid);
    }

}
