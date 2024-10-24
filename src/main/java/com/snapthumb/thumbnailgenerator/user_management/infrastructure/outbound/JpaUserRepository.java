package com.snapthumb.thumbnailgenerator.user_management.infrastructure.outbound;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.persistence.UserEntity;

import jakarta.persistence.EntityManager;

@Repository
public class JpaUserRepository implements UserRepository {

    private final EntityManager entityManager;

    public JpaUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(UserEntity.fromDomainModel(user));
    }

    @Override
    public Optional<User> search(UUID uuid) {
        UserEntity entity = entityManager.find(UserEntity.class, uuid);
        return Optional.ofNullable(entity).map(UserEntity::toDomainModel);
    }

}
