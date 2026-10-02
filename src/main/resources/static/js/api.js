async function fetchTriageQueue() {
    const response = await fetch('/api/triage');
    if (!response.ok) {
        throw new Error('Unable to fetch triage queue');
    }
    return response.json();
}

async function scorePatient(payload) {
    const response = await fetch('/api/triage/score', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    });
    if (!response.ok) {
        throw new Error('Unable to score patient');
    }
    return response.json();
}
