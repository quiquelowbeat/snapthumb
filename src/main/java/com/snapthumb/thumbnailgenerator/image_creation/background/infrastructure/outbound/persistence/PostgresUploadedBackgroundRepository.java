package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities.UploadedBackgroundEntity;

import jakarta.transaction.Transactional;

@Repository
public class PostgresUploadedBackgroundRepository implements UploadedBackgroundRepository {

    private final JpaUploadedBackgroundRepository repository;

    public PostgresUploadedBackgroundRepository(JpaUploadedBackgroundRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(UploadedBackground background) {
        repository.save(UploadedBackgroundEntity.fromDomainModel(background));
    }

    @Override
    public Optional<UploadedBackground> search(UUID uuid) {
        Optional<UploadedBackgroundEntity> optionalUploadedBackground = repository.findById(uuid);
        return optionalUploadedBackground.map(UploadedBackgroundEntity::toDomainModel);
    }

}
