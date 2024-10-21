package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;

@Service
public class UploadedBackgroundRegister {

    private final UploadedBackgroundRepository repository;

    public UploadedBackgroundRegister(UploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    public void register(String uuid, String url, String title, String description) {
        UploadedBackground background = new UploadedBackground(UUID.fromString(uuid), url, title, description);
        repository.save(background);
    }

}
