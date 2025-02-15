package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackgroundRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UploadedBackgroundRegister {

    private final UploadedBackgroundRepository repository;

    public UploadedBackgroundRegister(UploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    public void register(String uuid, String url, String title, String description, Instant uploadedAt) {
        UploadedBackground background = UploadedBackground.createFromPrimitives(uuid, url,
                title,
                description, uploadedAt);
        repository.save(background);
    }

}
