package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence.adapters;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities.AIBackgroundEntity;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence.JpaAIBackgroundRepository;

import jakarta.transaction.Transactional;

@Repository
public class PostgresAIBackgroundRepository implements AIBackgroundRepository {

    private final JpaAIBackgroundRepository repository;

    public PostgresAIBackgroundRepository(JpaAIBackgroundRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(AIBackground background) {
        repository.save(AIBackgroundEntity.fromDomainModel(background));
    }

    @Override
    public Optional<AIBackground> search(UUID uuid) {
        Optional<AIBackgroundEntity> optionalEntity = repository.findById(uuid);
        return optionalEntity.map(AIBackgroundEntity::toDomainModel);
    }

}
