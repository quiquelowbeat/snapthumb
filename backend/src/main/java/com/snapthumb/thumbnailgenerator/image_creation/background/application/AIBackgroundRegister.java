package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.time.LocalDateTime;

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
            LocalDateTime createdAt) {
        AIBackground background = AIBackground.createFromPrimitives(uuid, url, prompt, title,
                description, createdAt);
        repository.save(background);
    }

}
