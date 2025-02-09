package com.snapthumb.thumbnailgenerator.image_creation.background.infrastructure.outbound.ai_generation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({ "local", "dev" })
public class FalSchnellAIImageGenerator extends FalAIImageGenerator {

    private static final String FAL_AI_MODEL_ENDPOINT = "fal-ai/flux/schnell";
    private static final int NUMBER_OF_INFERENCE_STEPS = 4;

    @Override
    String falAIModelEndpoint() {
        return FAL_AI_MODEL_ENDPOINT;
    }

    @Override
    int numberOfInferenceSteps() {
        return NUMBER_OF_INFERENCE_STEPS;
    }

}
