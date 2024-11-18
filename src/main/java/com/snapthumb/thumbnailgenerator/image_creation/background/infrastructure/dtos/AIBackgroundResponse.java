package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGenerated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.Image;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@Schema(description = "Response object containing AI-generated background details")
public class AIBackgroundResponse {

    @JsonProperty("urls")
    @Schema(description = "URLs where the background images are stored", example = "https://example.com/image.jpg")
    private List<String> urls;

    @JsonProperty("createdAt")
    @Schema(description = "Timestamp when the image was created in the ai system", example = "2023-01-01T12:00:00")
    private LocalDateTime createdAt;

    private AIBackgroundResponse(List<String> urls, LocalDateTime createdAt) {
        this.urls = urls;
        this.createdAt = createdAt;
    }

    public static AIBackgroundResponse create(AIBackgroundGenerated aiBackgroundGenerated) {
        List<String> urls = aiBackgroundGenerated.images().stream()
                .map(Image::url)
                .toList();
        return new AIBackgroundResponse(urls, aiBackgroundGenerated.createdAt());
    }

}
