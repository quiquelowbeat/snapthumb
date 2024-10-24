package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.persistence.AIBackgroundEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class JpaAIBackgroundRepository implements AIBackgroundRepository {

    private final EntityManager entityManager;

    public JpaAIBackgroundRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(AIBackground background) {
        entityManager.persist(AIBackgroundEntity.fromDomainModel(background));
    }

}
