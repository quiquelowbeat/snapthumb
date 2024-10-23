package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;

@Service
public class AIBackgroundRegister {

    private final AIBackgroundRepository repository;

    public AIBackgroundRegister(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public void register(String uuid, String url, String prompt, String title, String description, LocalDateTime createdAt) {
        AIBackground background = AIBackground.create(UUID.fromString(uuid), url, prompt, title,
        description, createdAt);
        repository.save(background);
    }

}
