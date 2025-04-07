package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private LocalDateTime date;
    private String doctorFullName;
    private List<MedicalTreatmentTO> treatments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public List<MedicalTreatmentTO> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentTO> treatments) {
        this.treatments = treatments;
    }


}
