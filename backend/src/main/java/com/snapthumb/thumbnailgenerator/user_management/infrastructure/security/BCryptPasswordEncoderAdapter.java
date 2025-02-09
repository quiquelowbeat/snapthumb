package com.snapthumb.thumbnailgenerator.user_management.infrastructure.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.user_management.domain.DomainPasswordEncoder;

@Service
public class BCryptPasswordEncoderAdapter implements DomainPasswordEncoder {

    private final BCryptPasswordEncoder passwordEncoder;

    public BCryptPasswordEncoderAdapter(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }

}
