package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.DomainAIBackgroundFinder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AIBackgroundFinder {

    private final DomainAIBackgroundFinder finder;

    public AIBackgroundFinder(AIBackgroundRepository repository) {
        this.finder = new DomainAIBackgroundFinder(repository);
    }

    public AIBackground find(String uuid) {
        return finder.find(uuid);
    }

}
