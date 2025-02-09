package com.snapthumb.thumbnailgenerator.user_management.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserNotFound;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;

import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserFinder {

    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public Either<UserNotFound, User> find(String uuid) {
        return repository.search(UUID.fromString(uuid))
                .map(Either::<UserNotFound, User>right)
                .orElseGet(() -> Either.left(new UserNotFound("User with id " + uuid + " not found")));
    }
}
