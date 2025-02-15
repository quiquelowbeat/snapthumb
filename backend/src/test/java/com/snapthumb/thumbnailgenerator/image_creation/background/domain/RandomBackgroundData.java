package com.snapthumb.thumbnailgenerator.image_creation.background.domain;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBackgroundData {

    private static final List<String> URLS = Arrays.asList(
            "https://test-bucket.s3.amazonaws.com/backgrounds/image1.jpg",
            "https://test-bucket.s3.amazonaws.com/backgrounds/image2.jpg",
            "https://test-bucket.s3.amazonaws.com/backgrounds/image3.jpg",
            "https://test-bucket.s3.amazonaws.com/backgrounds/image4.jpg",
            "https://test-bucket.s3.amazonaws.com/backgrounds/image5.jpg");

    private static final List<String> PROMPTS = Arrays.asList(
            "Create a vibrant sunset over a mountain landscape",
            "Generate a futuristic cityscape with flying cars",
            "Design a serene beach scene with palm trees",
            "Make an abstract geometric pattern in blue tones",
            "Create a mystical forest with glowing elements");

    private static final List<String> TITLES = Arrays.asList(
            "Sunset Mountain Vista",
            "Futuristic Metropolis",
            "Tropical Paradise",
            "Abstract Blue Geometry",
            "Enchanted Forest");

    private static final List<String> DESCRIPTIONS = Arrays.asList(
            "A stunning mountain landscape at sunset with vibrant orange and purple hues.",
            "A modern cityscape with sleek skyscrapers and flying vehicles in a neon-lit sky.",
            "A peaceful beach scene with swaying palm trees and crystal clear turquoise waters.",
            "An abstract geometric composition featuring various shades of blue in a mesmerizing pattern.",
            "A magical forest setting with ethereal glowing elements among ancient trees.");

    private static final List<Instant> DATES = Arrays.asList(
            Instant.now().minusDays(5),
            Instant.now().minusHours(10),
            Instant.now().minusMonths(1),
            Instant.now().minusWeeks(2),
            Instant.now().minusDays(1));

    static final Random RANDOM = new Random();

    public static String randomUrl() {
        return URLS.get(RANDOM.nextInt(URLS.size()));
    }

    public static String randomPrompt() {
        return PROMPTS.get(RANDOM.nextInt(PROMPTS.size()));
    }

    public static String randomTitle() {
        return TITLES.get(RANDOM.nextInt(TITLES.size()));
    }

    public static String randomDescription() {
        return DESCRIPTIONS.get(RANDOM.nextInt(DESCRIPTIONS.size()));
    }

    public static Instant randomDates() {
        return DATES.get(RANDOM.nextInt(DATES.size()));
    }

}
