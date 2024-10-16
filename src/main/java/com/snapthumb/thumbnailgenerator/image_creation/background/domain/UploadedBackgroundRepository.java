package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadedBackgroundRepository extends JpaRepository<UploadedBackground, UUID> {
}
