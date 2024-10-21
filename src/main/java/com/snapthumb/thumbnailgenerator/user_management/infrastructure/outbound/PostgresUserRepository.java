package com.snapthumb.thumbnailgenerator.user_management.infrastructure.outbound;

import org.springframework.jdbc.core.JdbcTemplate;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;

public class PostgresUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public PostgresUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (uuid, name, last_name, email, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.uuid(), user.name(), user.lastName(), user.email(),
                user.hashedPassword());
    }

}
