package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import java.time.Instant;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ai.fal.client.Output;
import lombok.ToString;

@ToString
public class AIBackgroundGenerated {

    private List<Image> images;
    private Timings timings;
    private int seed;
    private List<Boolean> hasNsfwConcepts;
    private String prompt;
    private Instant createdAt;

    public AIBackgroundGenerated(List<Image> images, Timings timings, int seed, List<Boolean> hasNsfwConcepts,
            String prompt, Instant createdAt) {
        this.images = images;
        this.timings = timings;
        this.seed = seed;
        this.hasNsfwConcepts = hasNsfwConcepts;
        this.prompt = prompt;
        this.createdAt = createdAt;
    }

    public static AIBackgroundGenerated createFromJson(Output<JsonObject> output) {
        try {
            JsonObject json = output.getData();
            return new AIBackgroundGenerated(
                    extractImages(json),
                    extractTimings(json),
                    extractSeed(json),
                    extractNsfwConcepts(json),
                    extractPrompt(json),
                    Instant.now());
        } catch (ClassCastException e) {
            throw new AIBackgroundFailedResponse(
                    "Invalid JSON structure: Unable to parse AI background response fields", e);
        }
    }

    private static List<Image> extractImages(JsonObject json) {
        return json.getAsJsonArray("images").asList().stream()
                .map(imageElement -> new Image(
                        imageElement.getAsJsonObject().get("url").getAsString(),
                        imageElement.getAsJsonObject().get("content_type").getAsString()))
                .toList();
    }

    private static Timings extractTimings(JsonObject json) {
        JsonObject timingsJson = json.getAsJsonObject("timings");
        return new Timings(
                timingsJson.get("inference").getAsDouble());
    }

    private static int extractSeed(JsonObject json) {
        return json.get("seed").getAsInt();
    }

    private static List<Boolean> extractNsfwConcepts(JsonObject json) {
        return json.getAsJsonArray("has_nsfw_concepts").asList().stream()
                .map(JsonElement::getAsBoolean)
                .toList();
    }

    private static String extractPrompt(JsonObject json) {
        return json.get("prompt").getAsString();
    }

    public List<Image> images() {
        return images;
    }

    public Instant createdAt() {
        return createdAt;
    }

}
