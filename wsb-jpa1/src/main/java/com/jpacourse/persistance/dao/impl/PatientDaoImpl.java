package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    protected Class<PatientEntity> getDomainClass() {
        return PatientEntity.class;
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findWithMoreThanXVisits(long minVisits) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :minVisits", PatientEntity.class)
                .setParameter("minVisits", minVisits)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findByStatusLike(String statusPart) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.status LIKE CONCAT('%', :statusPart, '%')", PatientEntity.class)
                .setParameter("statusPart", statusPart)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findBornAfter(LocalDate date) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.dateOfBirth > :date", PatientEntity.class)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String visitDescription) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        if (patient == null || doctor == null) {
            throw new IllegalArgumentException("Patient or Doctor not found");
        }

        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(visitTime);
        visit.setDescription(visitDescription);

        // Add visit to patient
        patient.getVisits().add(visit);

        // Persist the new visit (if cascade is set, merging patient is enough)
        entityManager.persist(visit);
        entityManager.merge(patient);
    }
}
