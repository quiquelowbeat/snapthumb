package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.exceptions.CantRegisterBackground;

import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UploadedBackgroundRegister {

    private final UploadedBackgroundRepository repository;

    public UploadedBackgroundRegister(UploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    public void register(String uuid, String url, String title, String description, LocalDateTime uploadedAt) {
        try {
            UploadedBackground background = UploadedBackground.createFromPrimitives(UUID.fromString(uuid), url, title,
                    description, uploadedAt);
            repository.save(background);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Can't save Uploaded Background with UUID: {}.", uuid, e);
            throw new CantRegisterBackground(e, uuid);
        } catch (PersistenceException e) {
            log.error("Can't save Uploaded Background with UUID: {}.", uuid, e);
            throw new CantRegisterBackground(e, uuid);
        }
    }

}
