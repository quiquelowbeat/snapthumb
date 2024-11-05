package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class UploadedBackgroundEntity {

    @Id
    private UUID uuid;
    private String url;
    private String title;
    private String description;
    @Column(name = "uploaded_at", updatable = false)
    private LocalDateTime uploadedAt;
    @Column(name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    protected UploadedBackgroundEntity() {
    }

    private UploadedBackgroundEntity(UUID uuid, String url, String title, String description,
            LocalDateTime uploadedAt, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.url = url;
        this.title = title;
        this.description = description;
        this.uploadedAt = uploadedAt;
        this.registeredAt = registeredAt;
    }

    public UploadedBackground toDomainModel() {
        return UploadedBackground.createFromPrimitivesWithRegisteredAt(
                this.uuid,
                this.url,
                this.title,
                this.description,
                this.uploadedAt,
                this.registeredAt);
    }

    public static UploadedBackgroundEntity fromDomainModel(UploadedBackground uploadedBackground) {
        return new UploadedBackgroundEntity(uploadedBackground.uuid(), uploadedBackground.url(),
                uploadedBackground.title(), uploadedBackground.description(), uploadedBackground.uploadedAt(),
                uploadedBackground.registeredAt());
    }
}
