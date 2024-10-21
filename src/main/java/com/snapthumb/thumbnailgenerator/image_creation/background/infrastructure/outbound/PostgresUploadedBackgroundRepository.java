package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PostgresUploadedBackgroundRepository implements UploadedBackgroundRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public PostgresUploadedBackgroundRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(UploadedBackground background) {
        String sql = "INSERT INTO uploaded_backgrounds (uuid, url, title, description) VALUES (:uuid, :url, :title, :description)";
        Query query = entityManager.createNativeQuery(sql); 
        query.setParameter("uuid", background.uuid());
        query.setParameter("url", background.url());
        query.setParameter("title", background.title());
        query.setParameter("description", background.description());
        query.executeUpdate();
    }

}
