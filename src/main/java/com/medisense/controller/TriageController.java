package com.medisense.controller;

import com.medisense.service.TriageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TriageController {

    private final TriageService triageService;

    public TriageController(TriageService triageService) {
        this.triageService = triageService;
    }

    @GetMapping("/triage")
    public List<Map<String, Object>> getTriageQueue() {
        return triageService.getQueue();
    }

    @PostMapping("/triage/score")
    public ResponseEntity<Map<String, Object>> scorePatient(@RequestBody Map<String, Object> payload) {
        return ResponseEntity.ok(triageService.scorePatient(payload));
    }
}
