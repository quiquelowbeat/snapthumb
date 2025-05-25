package com.snapthumb.thumbnailgenerator.user_management.infrastructure.mappers;

import org.springframework.stereotype.Component;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;
import com.snapthumb.thumbnailgenerator.user_management.infrastructure.entities.UserEntity;

@Component
public class UserMapper {

    public User toDomainModel(UserEntity entity) {
        return User.createFromPrimitivesWithRegisteredAt(
                entity.uuid().toString(),
                entity.firstName(),
                entity.lastName(),
                entity.email(),
                entity.hashedPassword(),
                entity.registeredAt());
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(user.uuid(), user.firstName(), user.lastName(), user.email(), user.hashedPassword(),
                user.registeredAt());
    }

}
