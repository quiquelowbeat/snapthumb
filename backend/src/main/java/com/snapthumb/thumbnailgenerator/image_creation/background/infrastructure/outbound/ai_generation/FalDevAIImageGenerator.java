package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.ai_generation;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGenerated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGeneration;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Prompt;

import ai.fal.client.FalClient;
import ai.fal.client.Output;
import ai.fal.client.SubscribeOptions;
import ai.fal.client.queue.QueueStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("pro")
public class FalDevAIImageGenerator implements AIBackgroundGeneration {

    private static final String FAL_AI_MODEL_ENDPOINT = "fal-ai/flux/dev";
    private static final int NUMBER_OF_INFERENCE_STEPS = 28;
    private static final int NUMBER_OF_IMAGES = 3;
    private static final Map<String, Integer> IMAGE_SIZE = Map.of(
            "width", 1280,
            "height", 720);

    private FalClient falClient;

    public FalDevAIImageGenerator() {
        this.falClient = FalClient.withEnvCredentials();
    }

    @Override
    public AIBackgroundGenerated generate(Prompt prompt) {
        Map<String, Object> input = createInput(prompt);
        Output<JsonObject> outputFromFal = falClient.subscribe(FAL_AI_MODEL_ENDPOINT,
                SubscribeOptions.<JsonObject>builder()
                        .input(input)
                        .logs(true)
                        .resultType(JsonObject.class)
                        .onQueueUpdate(update -> {
                            if (update instanceof QueueStatus.InProgress) {
                                log.info("QueueStatus progress update: {}",
                                        ((QueueStatus.InProgress) update).getLogs());
                            }
                        })
                        .build());
        return AIBackgroundGenerated.createFromJson(outputFromFal);
    }

    private Map<String, Object> createInput(Prompt prompt) {
        return Map.of(
                "prompt",
                prompt.value(),
                "image_size", IMAGE_SIZE,
                "num_inference_steps", NUMBER_OF_INFERENCE_STEPS,
                "num_images", NUMBER_OF_IMAGES,
                "enable_safety_checker", true);
    }

}
