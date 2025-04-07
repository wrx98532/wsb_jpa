package com.jpacourse.dto;

public class MedicalTreatmentTO {
    private Long id;
    private String treatmentType;

    public String gettreatmentType() {
        return treatmentType;
    }

    public void settreatmentType(String name) {
        this.treatmentType = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
