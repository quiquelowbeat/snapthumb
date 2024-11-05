package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.util.Optional;
import java.util.UUID;

public interface UploadedBackgroundRepository {
    void save(UploadedBackground background);
    Optional<UploadedBackground> search(UUID uuid);
}
