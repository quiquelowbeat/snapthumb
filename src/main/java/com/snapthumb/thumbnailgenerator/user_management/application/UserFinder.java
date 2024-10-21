package com.snapthumb.thumbnailgenerator.user_management.application;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserDoesNotExists;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;

@Service
public class UserFinder {

    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User find(String uuid) {
        Optional<User> user = repository.search(UUID.fromString(uuid));
        if (user.isEmpty()) {
            throw new UserDoesNotExists(uuid);
        }
        return user.get();
    }

}
