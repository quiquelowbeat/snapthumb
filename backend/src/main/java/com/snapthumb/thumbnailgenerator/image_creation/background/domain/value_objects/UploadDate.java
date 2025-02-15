package com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects;

import java.time.Instant;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class UploadDate {

    private final Instant value;

    private UploadDate(Instant uploadedAt) {
        this.value = uploadedAt;
    }

    public Instant value() {
        return value;
    }

    public static UploadDate create(Instant uploadedAt) {
        if (uploadedAt == null) {
            throw new IllegalArgumentException("Upload date cannot be null. A valid Instant must be provided.");
        }
        if (uploadedAt != null && uploadedAt.equals(Instant.MIN)) {
            throw new IllegalArgumentException("Upload date cannot be empty. A valid date must be provided.");
        }
        if (uploadedAt != null && uploadedAt.isAfter(Instant.now())) {
            throw new IllegalArgumentException("Upload date cannot be in the future.");
        }
        return new UploadDate(uploadedAt);
    }

}
