from triage_scorer import score_patient


def test_high_risk_patient_scores_high():
    patient = {
        "patientId": "P-2001",
        "name": "Jane Doe",
        "age": 64,
        "vitals": {
            "heartRate": 130,
            "oxygenSaturation": 82,
            "systolic": 95,
            "respiratoryRate": 29,
        },
    }
    result = score_patient(patient)
    assert result["score"] >= 85
    assert result["category"] == "RED"


def test_normal_patient_scores_lower():
    patient = {
        "patientId": "P-2002",
        "name": "John Smith",
        "age": 34,
        "vitals": {
            "heartRate": 80,
            "oxygenSaturation": 98,
            "systolic": 118,
            "respiratoryRate": 16,
        },
    }
    result = score_patient(patient)
    assert result["score"] < 60
