package com.snapthumb.thumbnailgenerator.user_management.infrastructure.outbound;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PostgresUserRepository implements UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public PostgresUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (uuid, name, last_name, email, password) VALUES (:uuid, :name, :last_name, :email, :password)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("uuid", user.uuid());
        query.setParameter("name", user.name());
        query.setParameter("last_name", user.lastName());
        query.setParameter("email", user.email());
        query.setParameter("password", user.hashedPassword());
        query.executeUpdate();
    }

    @Override
    public Optional<User> search(UUID uuid) {
        String sql = "SELECT uuid, name, last_name, email, password FROM users WHERE uuid = :uuid";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("uuid", uuid);
        try {
            User user = (User) query.getSingleResult();
            return Optional.of(user);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
