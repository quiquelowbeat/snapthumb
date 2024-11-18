package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "uploaded_backgrounds")
@Schema(description = "Entity representing an uploaded background image")
public class UploadedBackgroundEntity {

    @Id
    @Schema(description = "Unique identifier for the uploaded background", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID uuid;

    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    private String url;

    @Schema(description = "Title of the background image", example = "Mountain Sunset")
    private String title;

    @Schema(description = "Description of the background image", example = "A beautiful mountain landscape with warm sunset colors")
    private String description;

    @Column(name = "uploaded_at", updatable = false)
    @Schema(description = "Timestamp when the image was uploaded", example = "2023-01-01T12:00:00")
    private LocalDateTime uploadedAt;

    @Column(name = "registered_at", updatable = false)
    @Schema(description = "Timestamp when the image was registered in the system", example = "2023-01-01T12:00:00")
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
