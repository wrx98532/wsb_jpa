
package com.jpacourse.persistance.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String telephoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String patientNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String status;  // Dodane nowe pole do testu

    // -------------------RELACJE-------------------

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Address_ID", referencedColumnName = "ID")
    private AddressEntity address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<VisitEntity> visits = new ArrayList<>();

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
    public AddressEntity getAddress() {
        return address;
    }

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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<VisitEntity> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitEntity> visits) {
        this.visits = visits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }
}
