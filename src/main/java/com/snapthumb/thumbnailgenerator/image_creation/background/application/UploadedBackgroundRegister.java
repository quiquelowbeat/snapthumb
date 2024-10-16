package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;

@Service
public class UploadedBackgroundRegister {

    private final UploadedBackgroundRepository repository;

    public UploadedBackgroundRegister(UploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    public void save(UploadedBackground background) {
        repository.save(background);
    }

}
