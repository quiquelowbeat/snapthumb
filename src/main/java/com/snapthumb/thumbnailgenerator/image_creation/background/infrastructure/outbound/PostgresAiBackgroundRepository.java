package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PostgresAiBackgroundRepository implements AIBackgroundRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public PostgresAiBackgroundRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(AIBackground background) {
        String sql = "INSERT INTO ai_backgrounds (uuid, url, prompt, title, description) VALUES (:uuid, :url, :prompt, :title, :description)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("uuid", background.uuid());
        query.setParameter("url", background.url());
        query.setParameter("prompt", background.prompt());
        query.setParameter("title", background.title());
        query.setParameter("description", background.description());
        query.executeUpdate();
    }

}
