package com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background;

import java.time.LocalDateTime;
import java.util.UUID;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Description;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.RegistrationDate;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Title;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.UploadDate;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Url;

public class UploadedBackground {

    private final UUID uuid;
    private final Url url;
    private final Title title;
    private final Description description;
    private final UploadDate uploadedAt;
    private final RegistrationDate registeredAt;

    private UploadedBackground(UUID uuid, Url url, Title title, Description description, UploadDate uploadedAt,
            RegistrationDate registeredAt) {
        this.uuid = uuid;
        this.url = url;
        this.title = title;
        this.description = description;
        this.uploadedAt = uploadedAt;
        this.registeredAt = registeredAt;
    }

    public static UploadedBackground createFromPrimitives(String uuid, String url, String title, String description,
            LocalDateTime uploadedAt) {
        return createUploadedBackground(uuid, url, title, description, uploadedAt, LocalDateTime.now());
    }

    public static UploadedBackground createFromPrimitivesWithRegisteredAt(String uuid, String url, String title,
            String description, LocalDateTime uploadedAt, LocalDateTime registeredAt) {
        return createUploadedBackground(uuid, url, title, description, uploadedAt, registeredAt);
    }

    private static UploadedBackground createUploadedBackground(String uuid, String url, String title,
            String description,
            LocalDateTime uploadedAt, LocalDateTime registeredAt) {
        return new UploadedBackground(
                UUID.fromString(uuid),
                Url.create(url),
                Title.create(title),
                Description.create(description),
                UploadDate.create(uploadedAt),
                RegistrationDate.create(registeredAt));
    }

    public UUID uuid() {
        return uuid;
    }

    public String stringUuid() {
        return uuid.toString();
    }

    public String url() {
        return url.value();
    }

    public String title() {
        return title.value();
    }

    public String description() {
        return description.value();
    }

    public LocalDateTime uploadedAt() {
        return uploadedAt.value();
    }

    public LocalDateTime registeredAt() {
        return registeredAt.value();
    }

}
