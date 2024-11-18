package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackgroundRepository;

import jakarta.persistence.EntityExistsException;

public class InMemoryUploadedBackgroundRepository implements UploadedBackgroundRepository {

    private final Map<UUID, UploadedBackground> uploadedBackgrounds = new HashMap<>();

    @Override
    public void save(UploadedBackground background) {
        if (uploadedBackgrounds.containsKey(background.uuid())) {
            throw new EntityExistsException();
        }
        uploadedBackgrounds.put(background.uuid(), background);
    }

    @Override
    public Optional<UploadedBackground> search(UUID uuid) {
        return Optional.ofNullable(uploadedBackgrounds.get(uuid));
    }

}
