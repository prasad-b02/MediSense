function renderChart(entries) {
    const container = document.getElementById('patient-card');
    if (!container) {
        return;
    }

    const bars = entries.map(entry => {
        const width = Math.max(10, entry.score);
        return `<div class="bar-row"><span>${entry.patientId}</span><div class="bar"><div class="bar-fill" style="width:${width}%"></div></div></div>`;
    }).join('');

    container.innerHTML = `<h3>Queue risk distribution</h3>${bars}`;
}
