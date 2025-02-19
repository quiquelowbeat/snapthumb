package com.snapthumb.thumbnailgenerator.user_management.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.DomainPasswordEncoder;
import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.domain.UserRepository;

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

    public void register(String uuid, String firstName, String lastName, String email,
            String password) {
        User user = User.createFromPrimitives(uuid, firstName, lastName, email,
                encoder.encode(password));
        repository.save(user);
        log.info("Successfully registered user with uuid: {}", uuid);
    }

}
