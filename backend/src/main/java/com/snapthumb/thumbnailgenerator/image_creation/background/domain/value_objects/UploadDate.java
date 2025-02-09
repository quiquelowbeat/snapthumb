package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class UploadDate {

    private final LocalDateTime value;

    private UploadDate(LocalDateTime uploadedAt) {
        this.value = uploadedAt;
    }

    public LocalDateTime value() {
        return value;
    }

    public static UploadDate create(LocalDateTime uploadedAt) {
        if (uploadedAt == null) {
            throw new IllegalArgumentException("Upload date cannot be null. A valid LocalDateTime must be provided.");
        }
        if (uploadedAt != null && uploadedAt.equals(LocalDateTime.MIN)) {
            throw new IllegalArgumentException("Upload date cannot be empty. A valid date must be provided.");
        }
        if (uploadedAt != null && uploadedAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Upload date cannot be in the future.");
        }
        return new UploadDate(uploadedAt);
    }

}
