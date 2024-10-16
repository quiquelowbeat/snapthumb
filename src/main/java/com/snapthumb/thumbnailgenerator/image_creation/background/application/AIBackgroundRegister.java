package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;

@Service
public class AIBackgroundRegister {

    private final AIBackgroundRepository repository;

    public AIBackgroundRegister(AIBackgroundRepository repository) {
        this.repository = repository;
    }

    public void save(AIBackground background) {
        repository.save(background);
    }

}
