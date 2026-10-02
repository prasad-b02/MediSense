document.addEventListener('DOMContentLoaded', async () => {
    const refreshButton = document.getElementById('refresh-btn');
    const tableBody = document.querySelector('#queue-table tbody');

    async function loadQueue() {
        try {
            const patients = await fetchTriageQueue();
            tableBody.innerHTML = patients.map(patient => `
                <tr>
                    <td>${patient.patientId}</td>
                    <td>${patient.score}</td>
                    <td>${patient.category}</td>
                    <td>${patient.priority}</td>
                </tr>
            `).join('');
            renderChart(patients);
        } catch (error) {
            console.error(error);
            tableBody.innerHTML = '<tr><td colspan="4">Unable to load queue.</td></tr>';
        }
    }

    refreshButton.addEventListener('click', () => {
        loadQueue();
        playAlertTone();
    });

    loadQueue();
});
