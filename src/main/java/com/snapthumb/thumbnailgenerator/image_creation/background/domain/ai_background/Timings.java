package com.snapthumb.thumbnailgenerator.image_creation.background.domain.ai_background;

import lombok.ToString;

@ToString
public class Timings {

    private double total;
    private double inference;

    public Timings(double total, double inference) {
        this.total = total;
        this.inference = inference;
    }

    public double total() {
        return total;
    }

    public double inference() {
        return inference;
    }

}
