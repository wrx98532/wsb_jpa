package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    // -------------------RELACJE-------------------

    //Relacja dwukierunkowa 1:wielu Doctor - Visit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Doctor_ID", referencedColumnName = "ID")
    private DoctorEntity doctor;

    //Relacja dwukierunkowa 1:wielu Patient - Visit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient_ID", referencedColumnName = "ID")
    private PatientEntity patient;

    //Relacja dwukierunkowa 1:wielu Visit - Mediacal Treatment
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "Visit_ID", referencedColumnName = "ID")
    //private VisitEntity visit;


    //Relacja dwukierunkowa 1:wielu Visit - Medical Treatmens
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "treatments")
    //private List<MedicalTreatmentEntity> medicaltreatment;



    @ManyToMany
    @JoinTable(
            name = "visit_treatments",
            joinColumns = @JoinColumn(name = "visit_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    private List<MedicalTreatmentEntity> treatments;



    // -------------------KONIEC RELACJI-------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public List<MedicalTreatmentEntity> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentEntity> treatments) {
        this.treatments = treatments;
    }


}
