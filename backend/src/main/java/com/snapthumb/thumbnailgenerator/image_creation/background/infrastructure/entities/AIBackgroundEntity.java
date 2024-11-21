package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ai_backgrounds")
@Schema(description = "Entity representing an AI-generated background image")
public class AIBackgroundEntity {

    @Id
    @Schema(description = "Unique identifier for the AI background", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID uuid;

    @Schema(description = "URL where the background image is stored", example = "https://example.com/image.jpg")
    private String url;

    @Schema(description = "Prompt used to generate the AI image", example = "A serene mountain landscape at sunset")
    private String prompt;

    @Schema(description = "Title of the background image", example = "Mountain Sunset")
    private String title;

    @Schema(description = "Description of the background image", example = "A beautiful mountain landscape with warm sunset colors")
    private String description;

    @Column(name = "created_at", updatable = false)
    @Schema(description = "Timestamp when the image was created", example = "2023-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Column(name = "registered_at", updatable = false)
    @Schema(description = "Timestamp when the image was registered in the system", example = "2023-01-01T12:00:00")
    private LocalDateTime registeredAt;

    protected AIBackgroundEntity() {
    }

    private AIBackgroundEntity(UUID uuid, String url, String prompt, String title, String description,
            LocalDateTime createdAt, LocalDateTime registeredAt) {
        this.uuid = uuid;
        this.url = url;
        this.prompt = prompt;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.registeredAt = registeredAt;
    }

    public AIBackground toDomainModel() {
        return AIBackground.createFromPrimitivesWithRegisteredAt(
                this.uuid,
                this.url,
                this.prompt,
                this.title,
                this.description,
                this.createdAt,
                this.registeredAt);
    }

    public static AIBackgroundEntity fromDomainModel(AIBackground aiBackground) {
        return new AIBackgroundEntity(aiBackground.uuid(), aiBackground.url(), aiBackground.prompt(),
                aiBackground.title(), aiBackground.description(), aiBackground.createdAt(),
                aiBackground.registeredAt());
    }

}
