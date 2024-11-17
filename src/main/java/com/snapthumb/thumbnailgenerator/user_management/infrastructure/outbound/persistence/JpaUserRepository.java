package com.snapthumb.thumbnailgenerator.user_management.infrastructure.outbound.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snapthumb.thumbnailgenerator.user_management.infrastructure.entities.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

}
