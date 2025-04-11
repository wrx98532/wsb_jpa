package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {

    private LocalDateTime time;
    private String doctorFullName;
    private List<String> treatmentTypes;

    public VisitTO() {
    }

    public VisitTO(LocalDateTime time, String doctorFullName, List<String> treatmentTypes) {
        this.time = time;
        this.doctorFullName = doctorFullName;
        this.treatmentTypes = treatmentTypes;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public List<String> getTreatmentTypes() {
        return treatmentTypes;
    }

    public void setTreatmentTypes(List<String> treatmentTypes) {
        this.treatmentTypes = treatmentTypes;
    }
}

