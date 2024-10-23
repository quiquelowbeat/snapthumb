package com.snapthumb.thumbnailgenerator.user_management.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.DomainPasswordEncoder;
import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;
import com.snapthumb.thumbnailgenerator.user_management.domain.exceptions.CantSaveUser;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Email;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.LastName;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.Name;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserRegister {

    private final UserRepository repository;
    private final DomainPasswordEncoder encoder;

    public UserRegister(UserRepository repository, DomainPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public void register(String uuid, String name, String lastName, String email, String password) {
        try {
            HashedPassword hashedPassword = encoder.encode(password);
            User user = User.create(UUID.fromString(uuid), new Name(name), new LastName(lastName),
                    new Email(email), hashedPassword);
            repository.save(user);
        } catch (Exception e) {
            log.error("Can't save user with UUID: {}", uuid, e);
            throw new CantSaveUser(uuid);
        }
    }

}
