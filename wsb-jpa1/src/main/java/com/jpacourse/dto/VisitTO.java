package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {

    private LocalDateTime time;
    private String doctorFullName;
    private List<String> treatments;  // List of treatment types from MedicalTreatment

    public VisitTO() {}

    public VisitTO(LocalDateTime time, String doctorFullName, List<String> treatments) {
        this.time = time;
        this.doctorFullName = doctorFullName;
        this.treatments = treatments;
    }

    // Gettery i settery
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

    public List<String> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<String> treatments) {
        this.treatments = treatments;
    }
}