
package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.List;

public class PatientTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String patientNumber;
    private String status;  // Dodane nowe pole
    private LocalDate dateOfBirth;
    private List<VisitTO> pastVisits;
    private AddressTO address;

    public PatientTO() {}

    public PatientTO(Long id, String firstName, String lastName, String email, String telephoneNumber,
                     String patientNumber, String status, LocalDate dateOfBirth, List<VisitTO> pastVisits, AddressTO address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.patientNumber = patientNumber;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.pastVisits = pastVisits;
        this.address = address;
    }

    // Gettery i settery
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AddressTO getAddress() {
        return address;
    }

    public void setAddress(AddressTO address) {
        this.address = address;
    }
}
