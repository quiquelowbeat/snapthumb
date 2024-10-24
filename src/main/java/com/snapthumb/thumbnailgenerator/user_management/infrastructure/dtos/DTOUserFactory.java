package com.snapthumb.thumbnailgenerator.user_management.infrastructure.dtos;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;

public class DTOUserFactory {

    private DTOUserFactory() {
    }

    public static UserResponse create(User user) {
        return new UserResponse(user.stringUuid(), user.firstName(), user.lastName(), user.email(),
                user.registeredAt());
    }

}
