package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.mappers;

import org.springframework.stereotype.Component;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities.UploadedBackgroundEntity;

@Component
public class UploadedBackgroundMapper {
    public UploadedBackgroundEntity toEntity(UploadedBackground uploadedBackground) {
        return new UploadedBackgroundEntity(
                uploadedBackground.uuid(),
                uploadedBackground.url(),
                uploadedBackground.title(),
                uploadedBackground.description(),
                uploadedBackground.uploadedAt(),
                uploadedBackground.registeredAt());
    }

    public UploadedBackground toDomainModel(UploadedBackgroundEntity entity) {
        return UploadedBackground.createFromPrimitivesWithRegisteredAt(
                entity.uuid().toString(),
                entity.url(),
                entity.title(),
                entity.description(),
                entity.uploadedAt(),
                entity.registeredAt());
    }
}
