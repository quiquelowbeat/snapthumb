package com.snapthumb.thumbnailgenerator.user_management.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.UserNotFound;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;

import io.vavr.control.Either;

@Service
public class UserDeleter {

    private final UserRepository repository;

    public UserDeleter(UserRepository repository) {
        this.repository = repository;
    }

    public Either<UserNotFound, Void> delete(String uuid) {
        return repository.search(UUID.fromString(uuid))
                .map(user -> {
                    repository.delete(uuid);
                    return Either.<UserNotFound, Void>right(null);
                })
                .orElseGet(() -> Either.left(new UserNotFound(uuid)));
    }

}
