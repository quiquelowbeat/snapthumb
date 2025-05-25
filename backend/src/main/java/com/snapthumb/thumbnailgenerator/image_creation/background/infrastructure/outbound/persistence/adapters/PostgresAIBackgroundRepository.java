package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence.adapters;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities.AIBackgroundEntity;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.mappers.AIBackgroundMapper;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence.JpaAIBackgroundRepository;

import jakarta.transaction.Transactional;

@Repository
public class PostgresAIBackgroundRepository implements AIBackgroundRepository {

    private final JpaAIBackgroundRepository repository;
    private final AIBackgroundMapper mapper;

    public PostgresAIBackgroundRepository(JpaAIBackgroundRepository repository, AIBackgroundMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void save(AIBackground background) {
        repository.save(mapper.toEntity(background));
    }

    @Override
    public Optional<AIBackground> search(UUID uuid) {
        Optional<AIBackgroundEntity> optionalEntity = repository.findById(uuid);
        return optionalEntity.map(mapper::toDomainModel);
    }

}
