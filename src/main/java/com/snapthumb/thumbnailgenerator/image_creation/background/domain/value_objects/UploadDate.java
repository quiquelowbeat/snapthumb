package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class UploadDate {

    private final LocalDateTime value;

    public UploadDate(LocalDateTime uploadedAt) {
        this.value = validateDate(uploadedAt);
    }

    public LocalDateTime value() {
        return value;
    }

    private LocalDateTime validateDate(LocalDateTime uploadedAt) {
        if (uploadedAt == null) {
            throw new IllegalArgumentException("Upload date cannot be null. A valid LocalDateTime must be provided.");
        }
        if (uploadedAt.equals(LocalDateTime.MIN)) {
            throw new IllegalArgumentException("Upload date cannot be empty. A valid date must be provided.");
        }
        if (uploadedAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Upload date cannot be in the future.");
        }
        return uploadedAt;
    }

}
