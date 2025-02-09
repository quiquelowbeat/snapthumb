package com.snapthumb.thumbnailgenerator.user_management.infrastructure.outbound.persistence.adapters;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.entities.UserEntity;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.outbound.persistence.JpaUserRepository;

@Repository
public class PostgresUserRepository implements UserRepository {

    private final JpaUserRepository repository;

    public PostgresUserRepository(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(User user) {
        repository.save(UserEntity.fromDomainModel(user));
    }

    @Override
    public Optional<User> search(UUID uuid) {
        return repository.findById(uuid).map(UserEntity::toDomainModel);
    }

}
