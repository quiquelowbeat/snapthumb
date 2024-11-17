package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.entities.AIBackgroundEntity;

public interface JpaAIBackgroundRepository extends JpaRepository<AIBackgroundEntity, UUID> {

}
