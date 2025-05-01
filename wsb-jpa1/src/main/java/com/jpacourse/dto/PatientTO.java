package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.List;

public class PatientTO {

    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String patientNumber;
    private String status;  // Dodane nowe pole
    private LocalDate dateOfBirth;
    private List<VisitTO> pastVisits;

    public PatientTO() {}

    public PatientTO(String firstName, String lastName, String email, String telephoneNumber,
                     String patientNumber, String status, LocalDate dateOfBirth, List<VisitTO> pastVisits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.patientNumber = patientNumber;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.pastVisits = pastVisits;
    }

    // Gettery i settery
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<VisitTO> getPastVisits() {
        return pastVisits;
    }

    public void setPastVisits(List<VisitTO> pastVisits) {
        this.pastVisits = pastVisits;
    }

    // Getter i setter dla statusu
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}