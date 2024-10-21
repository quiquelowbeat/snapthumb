package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;

@Repository
public class PostgresUploadedBackgroundRepository implements UploadedBackgroundRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostgresUploadedBackgroundRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(UploadedBackground background) {
        String sql = "INSERT INTO uploaded_backgrounds (uuid, url, title, description) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, background.uuid(), background.url(), background.title(), background.description());
    }

}
