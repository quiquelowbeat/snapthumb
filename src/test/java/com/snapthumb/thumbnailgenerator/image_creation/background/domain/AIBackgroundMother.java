package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

public class AIBackgroundMother {

        public static AIBackground createRandomBackground() {
                return AIBackground.create(
                                UUID.randomUUID(),
                                RandomAIBackgroundData.getRandomUrl(),
                                RandomAIBackgroundData.getRandomPrompt(),
                                RandomAIBackgroundData.getRandomTitle(),
                                RandomAIBackgroundData.getRandomDescription(),
                                RandomAIBackgroundData.getRandomCreatedAt());
        }

        public static AIBackground createCustomBackground(UUID uuid, String url, String prompt, String title,
                        String description, LocalDateTime createdAt) {
                return AIBackground.create(
                                uuid,
                                url,
                                prompt,
                                title,
                                description,
                                createdAt);
        }

        public static Stream<AIBackground> generateRandomAIBackgrounds(int count) {
                return Stream.generate(AIBackgroundMother::createRandomBackground).limit(count);
        }

}
