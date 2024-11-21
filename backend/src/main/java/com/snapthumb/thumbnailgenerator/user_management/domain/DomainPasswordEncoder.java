package com.snapthumb.thumbnailgenerator.user_management.domain;

import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;

public interface DomainPasswordEncoder {
    HashedPassword encode(String rawPassword);
    boolean matches(String rawPassword, String hashedPassword);
}
