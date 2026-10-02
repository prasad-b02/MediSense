package com.medisense.dmgt;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private final List<SeverityRule> rules = new ArrayList<>();

    public RuleEngine() {
        rules.add(new SeverityRule("Critical respiratory distress", 85, "Immediate escalation"));
        rules.add(new SeverityRule("Urgent intervention", 65, "Priority review"));
        rules.add(new SeverityRule("Routine monitoring", 35, "Monitor and document"));
    }

    public List<String> evaluate(int score) {
        List<String> matches = new ArrayList<>();
        for (SeverityRule rule : rules) {
            if (score >= rule.getThreshold()) {
                matches.add(rule.getAction());
            }
        }
        return matches;
    }
}
