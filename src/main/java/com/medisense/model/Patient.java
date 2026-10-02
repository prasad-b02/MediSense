package com.medisense.model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String sex;
    private String chiefComplaint;
    private List<String> preexistingConditions = new ArrayList<>();
    private Vitals vitals;

    public Patient() {
    }

    public Patient(String patientId, String name, int age, String sex, String chiefComplaint, List<String> preexistingConditions) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.chiefComplaint = chiefComplaint;
        this.preexistingConditions = preexistingConditions;
        this.vitals = new Vitals();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public List<String> getPreexistingConditions() {
        return preexistingConditions;
    }

    public void setPreexistingConditions(List<String> preexistingConditions) {
        this.preexistingConditions = preexistingConditions;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }
}
