package com.medisense.dmgt;

public class Proposition {
    private final String id;
    private final String text;
    private final double confidence;

    public Proposition(String id, String text, double confidence) {
        this.id = id;
        this.text = text;
        this.confidence = confidence;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public double getConfidence() {
        return confidence;
    }
}
