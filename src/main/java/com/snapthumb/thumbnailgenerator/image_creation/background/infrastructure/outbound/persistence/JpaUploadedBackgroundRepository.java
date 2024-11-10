package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos.UploadedBackgroundEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class JpaUploadedBackgroundRepository implements UploadedBackgroundRepository {

    private final EntityManager entityManager;

    public JpaUploadedBackgroundRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(UploadedBackground background) {
        entityManager.persist(UploadedBackgroundEntity.fromDomainModel(background));
    }

    @Override
    public Optional<UploadedBackground> search(UUID uuid) {
        UploadedBackgroundEntity uploadedBackgroundEntity = entityManager.find(UploadedBackgroundEntity.class, uuid);
        return Optional.ofNullable(uploadedBackgroundEntity).map(UploadedBackgroundEntity::toDomainModel);
    }

}
