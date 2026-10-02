package com.medisense.dmgt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RuleEngineTest {

    @Test
    void evaluatesCriticalAndUrgentRules() {
        RuleEngine ruleEngine = new RuleEngine();

        var criticalRules = ruleEngine.evaluate(90);
        var urgentRules = ruleEngine.evaluate(70);

        assertTrue(criticalRules.stream().anyMatch(action -> action.contains("Immediate")));
        assertTrue(urgentRules.stream().anyMatch(action -> action.contains("Priority")));
        assertFalse(ruleEngine.evaluate(10).stream().anyMatch(action -> action.contains("Immediate")));
    }
}
