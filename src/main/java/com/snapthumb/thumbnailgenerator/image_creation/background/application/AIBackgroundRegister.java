package com.snapthumb.thumbnailgenerator.image_creation.background.application;

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

    public void register(String uuid, String url, String prompt, String title, String description) {
        AIBackground background = new AIBackground(UUID.fromString(uuid), url, prompt, title, description);
        repository.save(background);
    }

}
