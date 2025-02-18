package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.ai_generation;

import java.util.Map;

import com.google.gson.JsonObject;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGenerated;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.AIBackgroundGeneration;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background.CantGenerateAIBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.value_objects.Prompt;

import ai.fal.client.FalClient;
import ai.fal.client.Output;
import ai.fal.client.SubscribeOptions;
import ai.fal.client.queue.QueueStatus;
import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class FalAIImageGenerator implements AIBackgroundGeneration {

    private static final int NUMBER_OF_IMAGES = 3;
    private static final Map<String, Integer> IMAGE_SIZE = Map.of(
            "width", 1280,
            "height", 720);

    private FalClient falClient;

    protected FalAIImageGenerator() {
        this.falClient = FalClient.withEnvCredentials();
    }

    @Override
    public Either<CantGenerateAIBackground, AIBackgroundGenerated> generate(Prompt prompt) {
        log.info("Generating image with Falschnell AI in environment: {}",
                System.getenv("SPRING_PROFILES_ACTIVE"));
        try {
            Map<String, Object> input = createInput(prompt);
            Output<JsonObject> outputFromFal = generateFalAIOutput(input);
            return Either.right(AIBackgroundGenerated.createFromJson(outputFromFal));
        } catch (Exception ex) {
            log.error("Unexpected error generating AI image: {}", ex.getMessage(), ex);
            return Either.left(new CantGenerateAIBackground(ex));
        }
    }

    private Output<JsonObject> generateFalAIOutput(Map<String, Object> input) {
        return falClient.subscribe(falAIModelEndpoint(),
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
    }

    private Map<String, Object> createInput(Prompt prompt) {
        return Map.of(
                "prompt",
                prompt.value(),
                "image_size", IMAGE_SIZE,
                "num_inference_steps", numberOfInferenceSteps(),
                "num_images", NUMBER_OF_IMAGES,
                "enable_safety_checker", true);
    }

    abstract String falAIModelEndpoint();

    abstract int numberOfInferenceSteps();

}
