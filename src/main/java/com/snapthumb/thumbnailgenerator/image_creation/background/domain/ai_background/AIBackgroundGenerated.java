package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import java.time.LocalDateTime;
import java.util.List;

import lombok.ToString;

@ToString
public class AIBackgroundGenerated {

    private List<Image> images;
    private Timings timings;
    private int seed;
    private List<Boolean> hasNsfwConcepts;
    private String prompt;
    private LocalDateTime createdAt;

    public AIBackgroundGenerated(List<Image> images, Timings timings, int seed, List<Boolean> hasNsfwConcepts,
            String prompt, LocalDateTime createdAt) {
        this.images = images;
        this.timings = timings;
        this.seed = seed;
        this.hasNsfwConcepts = hasNsfwConcepts;
        this.prompt = prompt;
        this.createdAt = createdAt;
    }

    public List<Image> images() {
        return images;
    }

    public Timings timings() {
        return timings;
    }

    public int seed() {
        return seed;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

}
