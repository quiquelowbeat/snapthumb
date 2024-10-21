package com.snapthumb.thumbnailgenerator.user_management.domain;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);
    Optional<User> search(UUID uuid);
}
