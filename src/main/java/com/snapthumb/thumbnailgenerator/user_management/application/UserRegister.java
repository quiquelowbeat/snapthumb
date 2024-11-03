package com.snapthumb.thumbnailgenerator.user_management.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.DomainPasswordEncoder;
import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;
import com.snapthumb.thumbnailgenerator.user_management.domain.exceptions.CantRegisterUser;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;

import jakarta.persistence.PersistenceException;
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

    public void register(String uuid, String firstName, String lastName, String email, String password) {
        try {
            HashedPassword hashedPassword = encoder.encode(password);
            User user = User.createFromPrimitives(uuid, firstName, lastName, email, hashedPassword.value());
            repository.save(user);
        } catch (IllegalArgumentException e) {
            log.error("Invalid UUID format: {}.", uuid, e);
            throw new CantRegisterUser(e, uuid);
        } catch (PersistenceException e) {
            log.error("Can't save user with UUID: {}.", uuid, e);
            throw new CantRegisterUser(e, uuid);
        }
    }

}
