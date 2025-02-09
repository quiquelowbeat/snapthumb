package com.snapthumb.thumbnailgenerator.user_management.domain;

public interface DomainPasswordEncoder {
    String encode(String rawPassword);
    boolean matches(String rawPassword, String hashedPassword);
}
