package com.snapthumb.thumbnailgenerator.user_management.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    void save(User user);

    Optional<User> search(UUID uuid);

    List<User> findAll();

    void delete(String uuid);

}
