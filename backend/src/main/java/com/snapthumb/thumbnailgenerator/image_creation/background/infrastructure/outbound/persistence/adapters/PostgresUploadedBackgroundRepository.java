package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence.adapters;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackgroundRepository;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.mappers.UploadedBackgroundMapper;
import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence.JpaUploadedBackgroundRepository;

import jakarta.transaction.Transactional;

@Repository
public class PostgresUploadedBackgroundRepository implements UploadedBackgroundRepository {

    private final JpaUploadedBackgroundRepository repository;
    private final UploadedBackgroundMapper mapper;

    public PostgresUploadedBackgroundRepository(JpaUploadedBackgroundRepository repository,
            UploadedBackgroundMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void save(UploadedBackground background) {
        repository.save(mapper.toEntity(background));
    }

    @Override
    public Optional<UploadedBackground> search(UUID uuid) {
        return repository.findById(uuid).map(mapper::toDomainModel);
    }

}
