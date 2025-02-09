package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackground;

public class AIBackgroundMother {

        private static AIBackground createRandomBackground() {
                return AIBackground.createFromPrimitives(
                                UUID.randomUUID().toString(),
                                RandomBackgroundData.randomUrl(),
                                RandomBackgroundData.randomPrompt(),
                                RandomBackgroundData.randomTitle(),
                                RandomBackgroundData.randomDescription(),
                                RandomBackgroundData.randomDates());
        }

        public static AIBackground createCustomBackground(String uuid, String url, String prompt, String title,
                        String description, LocalDateTime createdAt) {
                return AIBackground.createFromPrimitives(
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
