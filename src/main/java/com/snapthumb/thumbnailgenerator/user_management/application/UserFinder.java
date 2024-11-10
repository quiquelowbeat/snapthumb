package com.snapthumb.thumbnailgenerator.user_management.application;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;
import com.snapthumb.thumbnailgenerator.user_management.domain.exceptions.UserNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserFinder {

    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User find(String uuid) {
        try {
            Optional<User> user = repository.search(UUID.fromString(uuid));
            if (user.isEmpty()) {
                log.error("User not found with UUID: {}.", uuid);
                throw new UserNotFound(uuid);
            }
            return user.get();
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Invalid UUID format: {}.", uuid);
            throw new UserNotFound(uuid);
        }
    }

}
