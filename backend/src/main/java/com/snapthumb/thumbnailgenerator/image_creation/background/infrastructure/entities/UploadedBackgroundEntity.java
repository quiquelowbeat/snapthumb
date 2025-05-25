package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities;

import java.time.Instant;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "uploaded_backgrounds")
@Schema(description = "Entity representing an uploaded background image")
@Getter
@Accessors(fluent = true)
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
    @Schema(description = "Timestamp when the image was uploaded in ISO 8601 format", example = "2023-01-01T12:00:00.000000Z")
    private Instant uploadedAt;

    @Column(name = "registered_at", updatable = false)
    @Schema(description = "Timestamp when the image was registered in the system in ISO 8601 format", example = "2023-01-01T12:00:00.000000Z")
    private Instant registeredAt;

    protected UploadedBackgroundEntity() {
    }

    public UploadedBackgroundEntity(UUID uuid, String url, String title, String description,
            Instant uploadedAt, Instant registeredAt) {
        this.uuid = uuid;
        this.url = url;
        this.title = title;
        this.description = description;
        this.uploadedAt = uploadedAt;
        this.registeredAt = registeredAt;
    }

}
