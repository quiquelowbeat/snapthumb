package com.snapthumb.thumbnailgenerator.user_management.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.shared.domain.exceptions.InvalidUuidFormat;
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
            return repository.search(UUID.fromString(uuid)).orElseThrow(() -> new UserNotFound(uuid));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new InvalidUuidFormat(uuid);
        }
    }

}
