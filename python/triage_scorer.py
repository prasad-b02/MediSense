from __future__ import annotations

from typing import Any, Dict

from python.regression_model import RegressionRiskModel, build_feature


def score_patient(patient: Dict[str, Any]) -> Dict[str, Any]:
    model = RegressionRiskModel()
    feature = build_feature(patient)
    raw_score = model.score(feature)
    rounded = min(100, max(0, round(raw_score)))

    if rounded >= 85:
        category = "RED"
    elif rounded >= 60:
        category = "YELLOW"
    elif rounded >= 35:
        category = "GREEN"
    else:
        category = "BLUE"

    return {
        "patientId": patient.get("patientId", "unknown"),
        "score": rounded,
        "category": category,
        "risk": round(raw_score / 100, 2),
    }
