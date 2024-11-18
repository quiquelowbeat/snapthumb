package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import lombok.ToString;

@ToString
public class Timings {

    private double inference;

    public Timings(double inference) {
        this.inference = inference;
    }

    public double inference() {
        return inference;
    }

}
