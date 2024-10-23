package com.snapthumb.thumbnailgenerator.user_management.domain.dtos;

import com.snapthumb.thumbnailgenerator.user_management.domain.User;

public class DTOFactory {

    private DTOFactory() {
    }

    public static UserResponse create(User user) {
        return new UserResponse(user.uuid().toString(), user.name().value(), user.lastName().value(),
                user.email().value(), user.registeredAt());
    }

}
