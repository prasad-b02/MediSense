package com.medisense.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TriageService {

    public List<Map<String, Object>> getQueue() {
        return List.of(
                Map.of("patientId", "P-1001", "score", 92, "category", "RED", "priority", 1),
                Map.of("patientId", "P-1002", "score", 74, "category", "YELLOW", "priority", 2),
                Map.of("patientId", "P-1003", "score", 41, "category", "GREEN", "priority", 3)
        );
    }

    public Map<String, Object> scorePatient(Map<String, Object> payload) {
        int score = 0;
        Object rawPulse = payload.getOrDefault("heartRate", 0);
        Object rawSpo2 = payload.getOrDefault("oxygenSaturation", 100);
        Object rawResp = payload.getOrDefault("respiratoryRate", 16);

        if (rawPulse instanceof Number) {
            score += Math.max(0, ((Number) rawPulse).intValue() - 100) * 2;
        }

        if (rawSpo2 instanceof Number) {
            score += Math.max(0, 100 - ((Number) rawSpo2).intValue()) * 2;
        }

        if (rawResp instanceof Number) {
            score += Math.max(0, ((Number) rawResp).intValue() - 18) * 3;
        }

        score = Math.min(100, Math.max(0, score));
        String category = score >= 85 ? "RED" : score >= 60 ? "YELLOW" : score >= 35 ? "GREEN" : "BLUE";

        return Map.of("score", score, "category", category, "priority", score >= 85 ? 1 : score >= 60 ? 2 : 3);
    }
}
