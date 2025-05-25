package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.mappers;

import org.springframework.stereotype.Component;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities.AIBackgroundEntity;

@Component
public class AIBackgroundMapper {
    public AIBackgroundEntity toEntity(AIBackground aiBackground) {
        return new AIBackgroundEntity(
                aiBackground.uuid(),
                aiBackground.url(),
                aiBackground.prompt(),
                aiBackground.title(),
                aiBackground.description(),
                aiBackground.createdAt(),
                aiBackground.registeredAt());
    }

    public AIBackground toDomainModel(AIBackgroundEntity entity) {
        return AIBackground.createFromPrimitivesWithRegisteredAt(
                entity.uuid().toString(),
                entity.url(),
                entity.prompt(),
                entity.title(),
                entity.description(),
                entity.createdAt(),
                entity.registeredAt());
    }
}
