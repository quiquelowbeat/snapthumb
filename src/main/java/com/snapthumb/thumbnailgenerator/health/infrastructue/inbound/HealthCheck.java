package com.snapthumb.thumbnailgenerator.health.infrastructue.inbound;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/health")
@Tag(name = "Health", description = "Health check endpoints")
public class HealthCheck {

    private final DataSource dataSource;

    public HealthCheck(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping
    public ResponseEntity<String> checkHealth() {
        if (isDatabaseHealthy()) {
            return ResponseEntity.ok("SnapThumb is up and running. All services are healthy.");
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("SnapThumb is experiencing issues.");
        }
    }

    private boolean isDatabaseHealthy() {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

}
