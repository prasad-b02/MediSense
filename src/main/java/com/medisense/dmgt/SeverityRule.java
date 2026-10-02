package com.medisense.dmgt;

public class SeverityRule {
    private final String name;
    private final int threshold;
    private final String action;

    public SeverityRule(String name, int threshold, String action) {
        this.name = name;
        this.threshold = threshold;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public int getThreshold() {
        return threshold;
    }

    public String getAction() {
        return action;
    }
}
