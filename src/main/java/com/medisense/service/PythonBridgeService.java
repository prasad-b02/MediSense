package com.medisense.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PythonBridgeService {

    public Map<String, Object> invokeScorer(Map<String, Object> patientData) {
        return Map.of(
                "status", "python_bridge_ready",
                "patientId", patientData.getOrDefault("patientId", "unknown"),
                "category", "RED",
                "score", 82
        );
    }
}
