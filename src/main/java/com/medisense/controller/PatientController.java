package com.medisense.controller;

import com.medisense.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @GetMapping
    public List<Patient> listPatients() {
        return List.of(
                new Patient("P-1001", "Aisha Khan", 34, "F", "Shortness of breath", List.of("Asthma")),
                new Patient("P-1002", "Daniel Ortiz", 58, "M", "Chest pain", List.of("Hypertension"))
        );
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable String id) {
        return new Patient(id, "Sample Patient", 42, "U", "Monitor for triage status", List.of("None"));
    }
}
