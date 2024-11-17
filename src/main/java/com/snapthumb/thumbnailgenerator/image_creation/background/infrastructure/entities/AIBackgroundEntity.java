package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ai_backgrounds")
public class AIBackgroundEntity {

    @Id
    private UUID uuid;
    private String url;
    private String prompt;
    private String title;
    private String description;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "registered_at", updatable = false)
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
