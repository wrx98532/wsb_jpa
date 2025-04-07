package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.List;

public class PatientTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate; // <- dodatkowe pole
    private List<VisitTO> pastVisits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<VisitTO> getPastVisits() {
        return pastVisits;
    }

    public void setPastVisits(List<VisitTO> pastVisits) {
        this.pastVisits = pastVisits;
    }
}
