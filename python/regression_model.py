from __future__ import annotations

from dataclasses import dataclass


@dataclass
class TriageFeature:
    heart_rate: int
    oxygen_saturation: int
    systolic_bp: int
    respiratory_rate: int
    age: int


class RegressionRiskModel:
    """Simple rule-based regression-style risk model."""

    def score(self, feature: TriageFeature) -> float:
        score = 0.0
        score += max(0, feature.heart_rate - 100) * 0.7
        score += max(0, 100 - feature.oxygen_saturation) * 1.4
        score += max(0, 140 - feature.systolic_bp) * 0.5
        score += max(0, feature.respiratory_rate - 20) * 1.2
        score += max(0, feature.age - 50) * 0.3
        return round(score, 2)


def build_feature(patient: dict) -> TriageFeature:
    vitals = patient.get("vitals", {})
    age = patient.get("age", 0)
    return TriageFeature(
        heart_rate=int(vitals.get("heartRate", 0)),
        oxygen_saturation=int(vitals.get("oxygenSaturation", 100)),
        systolic_bp=int(vitals.get("systolic", 120)),
        respiratory_rate=int(vitals.get("respiratoryRate", 16)),
        age=int(age),
    )
