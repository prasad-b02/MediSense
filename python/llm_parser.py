from __future__ import annotations

import json
import re
from typing import Any, Dict


def parse_patient_text(raw_text: str) -> Dict[str, Any]:
    cleaned = raw_text.strip()
    data = {
        "patientId": "unknown",
        "name": "Unknown",
        "age": 0,
        "sex": "U",
        "chiefComplaint": cleaned[:80],
        "preexistingConditions": [],
        "vitals": {},
    }

    match_id = re.search(r"patient[_ -]?id[:=]\s*([A-Za-z0-9-]+)", cleaned, re.IGNORECASE)
    if match_id:
        data["patientId"] = match_id.group(1)

    match_age = re.search(r"age[:=]\s*(\d{1,3})", cleaned, re.IGNORECASE)
    if match_age:
        data["age"] = int(match_age.group(1))

    match_sex = re.search(r"sex[:=]\s*([A-Z]+)", cleaned, re.IGNORECASE)
    if match_sex:
        data["sex"] = match_sex.group(1).upper()

    raw_json = re.search(r"\{.*\}", cleaned, re.DOTALL)
    if raw_json:
        try:
            return {**data, **json.loads(raw_json.group(0))}
        except json.JSONDecodeError:
            pass

    return data
