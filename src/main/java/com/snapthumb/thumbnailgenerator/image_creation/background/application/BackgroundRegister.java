package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.Background;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.BackgroundRepository;

public class BackgroundRegister {

    private final BackgroundRepository backgroundRepository;

    public BackgroundRegister(BackgroundRepository backgroundRepository) {
        this.backgroundRepository = backgroundRepository;
    }

    public void save(Background background) {
        backgroundRepository.save(background);
    }

}
