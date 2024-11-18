package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;

public class UploadedBackgroundMother {

    private static UploadedBackground createRandomBackground() {
        return UploadedBackground.createFromPrimitives(
                UUID.randomUUID(),
                RandomBackgroundData.randomUrl(),
                RandomBackgroundData.randomTitle(),
                RandomBackgroundData.randomDescription(),
                RandomBackgroundData.randomDates());
    }

    public static UploadedBackground createCustomBackground(UUID uuid, String url, String title,
            String description, LocalDateTime createdAt) {
        return UploadedBackground.createFromPrimitives(
                uuid,
                url,
                title,
                description,
                createdAt);
    }

    public static Stream<UploadedBackground> generateRandomUploadedBackgrounds(int count) {
        return Stream.generate(UploadedBackgroundMother::createRandomBackground).limit(count);
    }

}
