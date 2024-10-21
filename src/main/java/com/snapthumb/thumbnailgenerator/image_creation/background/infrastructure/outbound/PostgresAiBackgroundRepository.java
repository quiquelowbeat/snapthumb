package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.AIBackgroundRepository;

@Repository
public class PostgresAiBackgroundRepository implements AIBackgroundRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostgresAiBackgroundRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(AIBackground background) {
        String sql = "INSERT INTO ai_backgrounds (uuid, url, prompt, title, description) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, background.uuid(), background.url(), background.prompt(), background.title(),
                background.description());
    }

}
