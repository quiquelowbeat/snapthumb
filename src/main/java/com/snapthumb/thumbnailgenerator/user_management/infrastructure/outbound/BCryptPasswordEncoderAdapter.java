package com.snapthumb.thumbnailgenerator.user_management.infrastructure.outbound;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.snapthumb.thumbnailgenerator.user_management.domain.DomainPasswordEncoder;
import com.snapthumb.thumbnailgenerator.user_management.domain.value_objects.HashedPassword;

public class BCryptPasswordEncoderAdapter implements DomainPasswordEncoder {

    private final BCryptPasswordEncoder passwordEncoder;

    public BCryptPasswordEncoderAdapter(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public HashedPassword encode(String rawPassword) {
        return new HashedPassword(passwordEncoder.encode(rawPassword));
    }

    @Override
    public boolean matches(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }

}
