package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.DomainBackgroundFinder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AIBackgroundFinder {

    private final DomainBackgroundFinder finder;

    public AIBackgroundFinder(AIBackgroundRepository repository) {
        this.finder = new DomainBackgroundFinder(repository);
    }

    public AIBackground find(String uuid) {
        return finder.find(uuid);
    }

}
