# MediSense

MediSense is a full-stack triage and decision support application for emergency and clinical workflow analysis.

## Project layout

- `data/` contains sample patient and triage export records
- `python/` contains scoring and inference utilities used by the backend
- `src/main/java/` contains the Java/Spring Boot application
- `src/test/java/` contains project tests

## Run backend

```bash
mvn spring-boot:run
```

## Run Python checks

```bash
cd python
python -m pytest -q
```

## Notes

This scaffold is designed to support triage scoring, rule-based prioritization, and frontend visualization.
