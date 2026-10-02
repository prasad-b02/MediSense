package com.medisense.model;

public class PatientAgentState {
    private String patientId;
    private String agentName;
    private String state;
    private String notes;
    private long lastUpdatedMillis;

    public PatientAgentState(String patientId, String agentName, String state, String notes) {
        this.patientId = patientId;
        this.agentName = agentName;
        this.state = state;
        this.notes = notes;
        this.lastUpdatedMillis = System.currentTimeMillis();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getLastUpdatedMillis() {
        return lastUpdatedMillis;
    }

    public void setLastUpdatedMillis(long lastUpdatedMillis) {
        this.lastUpdatedMillis = lastUpdatedMillis;
    }
}
